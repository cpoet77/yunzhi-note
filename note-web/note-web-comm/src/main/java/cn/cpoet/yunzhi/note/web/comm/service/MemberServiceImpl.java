package cn.cpoet.yunzhi.note.web.comm.service;

import cn.cpoet.yunzhi.note.api.auth.Subject;
import cn.cpoet.yunzhi.note.api.exception.ReqsException;
import cn.cpoet.yunzhi.note.comm.constant.CommReqsStatus;
import cn.cpoet.yunzhi.note.domain.dao.GroupDao;
import cn.cpoet.yunzhi.note.domain.dao.MemberDao;
import cn.cpoet.yunzhi.note.domain.model.Group;
import cn.cpoet.yunzhi.note.domain.model.Member;
import cn.cpoet.yunzhi.note.web.comm.vo.MemberInfoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author CPoet
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final GroupDao groupDao;
    private final MemberDao memberDao;


    @Override
    public MemberInfoVO getInfo(Subject subject) {
        Member member = memberDao.findById(subject.getUid());
        if (member == null) {
            throw new ReqsException(CommReqsStatus.USER_STATUS_ERROR);
        }
        MemberInfoVO infoVO = new MemberInfoVO();
        infoVO.setId(member.getId());
        infoVO.setAccount(member.getAccount());
        infoVO.setNickName(member.getNickName());
        infoVO.setSummary(member.getSummary());
        Group group = groupDao.findById(member.getGroupId());
        if (group != null) {
            infoVO.setGroupId(group.getId());
            infoVO.setGroupName(group.getName());
        }
        return infoVO;
    }
}
