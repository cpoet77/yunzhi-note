package cn.wanggf.yunzhi.note.service.impl;

import cn.wanggf.yunzhi.note.comm.domain.Member;
import cn.wanggf.yunzhi.note.comm.service.FnMemberService;
import cn.wanggf.yunzhi.note.service.annotation.FeignProvider;

/**
 * @author wanggf
 */
@FeignProvider
public class FnMemberServiceImpl implements FnMemberService {
    @Override
    public Member getById(Long memberId) {
        Member member = new Member();
        member.setId(memberId);
        return member;
    }
}
