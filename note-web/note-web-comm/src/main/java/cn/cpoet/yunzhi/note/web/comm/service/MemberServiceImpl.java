package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.api.constant.SystemConst;
import cn.cpoet.yunzhi.note.api.exception.ReqsException;
import cn.cpoet.yunzhi.note.comm.cache.CacheKey;
import cn.cpoet.yunzhi.note.comm.constant.CommReqsStatus;
import cn.cpoet.yunzhi.note.comm.constant.ElExpEnum;
import cn.cpoet.yunzhi.note.domain.model.Group;
import cn.cpoet.yunzhi.note.domain.model.Member;
import cn.cpoet.yunzhi.note.domain.service.IGroupService;
import cn.cpoet.yunzhi.note.domain.service.IMemberService;
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
    private final IGroupService iGroupService;
    private final IMemberService iMemberService;

    @Override
    @Cacheable
    public MemberInfoVO getInfo(@CacheKey(value = "#uid", elExp = ElExpEnum.SPEL) Subject subject) {
        Member member = iMemberService.findById(subject.getUid());
        if (member == null) {
            throw new ReqsException(CommReqsStatus.USER_STATUS_ERROR);
        }
        MemberInfoVO infoVO = new MemberInfoVO();
        infoVO.setId(member.getId());
        infoVO.setAccount(member.getAccount());
        infoVO.setNickName(member.getNickName());
        infoVO.setSummary(member.getSummary());
        if (member.getGroupId() != SystemConst.DEFAULT_ENTITY_ID) {
            Group group = iGroupService.findById(member.getGroupId());
            if (group == null) {
                throw new ReqsException(CommReqsStatus.USER_STATUS_ERROR, "用户组状态异常");
            }
            infoVO.setGroupId(group.getId());
            infoVO.setGroupName(group.getName());
        }
        return infoVO;
    }
}
