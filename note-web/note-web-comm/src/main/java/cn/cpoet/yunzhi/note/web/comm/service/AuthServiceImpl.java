package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.api.core.RequestWrapper;
import cn.cpoet.yunzhi.note.api.exception.ReqsException;
import cn.cpoet.yunzhi.note.api.util.AppContextUtil;
import cn.cpoet.yunzhi.note.auth.component.JwtSupport;
import cn.cpoet.yunzhi.note.comm.util.PassUtil;
import cn.cpoet.yunzhi.note.comm.util.ReqsUtil;
import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import cn.cpoet.yunzhi.note.domain.constant.LoginType;
import cn.cpoet.yunzhi.note.domain.model.LoginLog;
import cn.cpoet.yunzhi.note.domain.model.Member;
import cn.cpoet.yunzhi.note.domain.service.IMemberService;
import cn.cpoet.yunzhi.note.web.comm.constant.ReqsStatus;
import cn.cpoet.yunzhi.note.web.comm.dto.AccountPassDTO;
import cn.cpoet.yunzhi.note.web.comm.vo.AuthTokenVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author CPoet
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtSupport jwtSupport;
    private final IMemberService iMemberService;
    private final LoginLogService loginLogService;

    @Override
    public AuthTokenVO login(AccountPassDTO accountPass) {
        Member member = iMemberService.getByAccount(accountPass.getAccount());
        if (member == null) {
            throw new ReqsException(ReqsStatus.ACCOUNT_PASS_ERROR);
        }
        if (!PassUtil.verify(accountPass.getPassword(), member.getSalt(), member.getPassword())) {
            throw new ReqsException(ReqsStatus.ACCOUNT_PASS_ERROR);
        }
        checkMemberStatus(member);
        handleLoginLog(member, accountPass);
        return signToken(member);
    }

    @Override
    public AuthTokenVO signToken(Member member) {
        AuthTokenVO authToken = new AuthTokenVO();
        authToken.setUid(member.getId());
        Subject subject = jwtSupport.genAuthSubject(member.getId(), member.getAccount(), member.getGroupId());
        authToken.setToken(jwtSupport.getToken(subject));
        return authToken;
    }

    @Override
    public void checkMemberStatus(Member member) {
        if (CommStatus.DISABLED.equals(member.getStatus())) {
            throw new ReqsException(ReqsStatus.MEMBER_DISABLED);
        }
        if (Boolean.TRUE.equals(member.getLocked())) {
            if (member.getLockedExpired() == null) {
                throw new ReqsException(ReqsStatus.MEMBER_LOCKED);
            }
            LocalDateTime lockedExpired = member.getLockedExpired();
            // 锁定已经失效
            if (lockedExpired.isBefore(AppContextUtil.getReqsTime())) {
                member.setLocked(Boolean.FALSE);
                iMemberService.update(member);
            } else {
                String msg = String.format("账号被锁定至 %s", member.getExpiredTime());
                throw new ReqsException(ReqsStatus.MEMBER_LOCKED, msg);
            }
        }
        if (LocalDateTime.now().isAfter(member.getExpiredTime())) {
            throw new ReqsException(ReqsStatus.MEMBER_EXPIRED);
        }
    }

    /**
     * 记录登录日志
     *
     * @param member      登录人员
     * @param accountPass 登录信息
     */
    private void handleLoginLog(Member member, AccountPassDTO accountPass) {
        RequestWrapper requestWrapper = AppContextUtil.getRequestWrapper();
        LoginLog loginLog = new LoginLog();
        loginLog.setMemberId(member.getId());
        loginLog.setAccount(accountPass.getAccount());
        loginLog.setLoginType(LoginType.ACCOUNT);
        loginLog.setIpAddr(ReqsUtil.findIpAddress(requestWrapper));
        loginLog.setUserAgent(ReqsUtil.getUserAgent(requestWrapper));
        loginLog.setOs(accountPass.getOs());
        loginLog.setScreen(accountPass.getScreen());
        loginLog.setLoginTime(AppContextUtil.getReqsTime());
        loginLogService.log(loginLog);
    }
}
