package cn.wanggf.yunzhi.note.comm.service;

import cn.wanggf.yunzhi.note.comm.constant.ModuleConst;
import cn.wanggf.yunzhi.note.comm.domain.Member;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户
 *
 * @author wanggf
 */
@FeignClient(name = ModuleConst.SERVER_SERVICE)
public interface FnMemberService {
    /**
     * 查询用户
     *
     * @param memberId 用户id
     * @return 用户
     */
    Member getById(Long memberId);
}
