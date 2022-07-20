package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.api.exception.ReqsException;
import cn.cpoet.yunzhi.note.comm.constant.CommReqsStatus;
import cn.cpoet.yunzhi.note.domain.business.GroupBusiness;
import cn.cpoet.yunzhi.note.domain.business.MemberBusiness;
import cn.cpoet.yunzhi.note.domain.model.Group;
import cn.cpoet.yunzhi.note.domain.model.Member;
import cn.cpoet.yunzhi.note.web.comm.vo.MemberInfoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author CPoet
 */
@Slf4j
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = SystemConst.CACHE_NAMES_MEMBER)
public class MemberServiceImpl implements MemberService {
    private final GroupBusiness groupBusiness;
    private final MemberBusiness memberBusiness;

    @Override
    @Cacheable(key = "'member:' + #subject.uid + ':getInfo'")
    public MemberInfoVO getInfo(Subject subject) {
        Member member = memberBusiness.findById(subject.getUid());
        if (member == null) {
            throw new ReqsException(CommReqsStatus.USER_STATUS_ERROR);
        }
        MemberInfoVO infoVO = new MemberInfoVO();
        infoVO.setId(member.getId());
        infoVO.setAccount(member.getAccount());
        infoVO.setNickName(member.getNickName());
        infoVO.setSummary(member.getSummary());
        Group group = groupBusiness.findById(member.getGroupId());
        if (group == null) {
            throw new ReqsException(CommReqsStatus.USER_STATUS_ERROR, "用户组状态异常");
        }
        infoVO.setGroupId(group.getId());
        infoVO.setGroupName(group.getName());
        return infoVO;
    }
}
