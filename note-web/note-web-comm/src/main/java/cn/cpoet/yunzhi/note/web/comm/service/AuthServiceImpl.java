package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.api.exception.ReqsException;
import cn.cpoet.yunzhi.note.auth.component.JwtSupport;
import cn.cpoet.yunzhi.note.comm.util.PassUtil;
import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import cn.cpoet.yunzhi.note.domain.dao.MemberDao;
import cn.cpoet.yunzhi.note.domain.model.Member;
import cn.cpoet.yunzhi.note.web.comm.constant.ReqsStatus;
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
    private final MemberDao memberDao;
    private final JwtSupport jwtSupport;

    @Override
    public AuthTokenVO login(String account, String password) {
        log.info("用户登录，测试测试。");
        Member member = memberDao.getByAccount(account);
        if (member == null) {
            throw new ReqsException(ReqsStatus.ACCOUNT_PASS_ERROR);
        }
        if (!PassUtil.verify(password, member.getSalt(), member.getPassword())) {
            throw new ReqsException(ReqsStatus.ACCOUNT_PASS_ERROR);
        }
        checkMemberStatus(member);
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
            throw new ReqsException(ReqsStatus.MEMBER_DISABLED);
        }
        if (LocalDateTime.now().isAfter(member.getExpiredTime())) {
            throw new ReqsException(ReqsStatus.MEMBER_EXPIRED);
        }
    }
}
