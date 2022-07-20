package cn.cpoet.yunzhi.note.domain.service;

import cn.cpoet.yunzhi.note.domain.base.BaseService;
import cn.cpoet.yunzhi.note.domain.model.Member;

/**
 * @author CPoet
 */
public interface IMemberService extends BaseService<Member> {
    /**
     * 根据账号查询
     *
     * @param account 用户账号
     * @return 用户信息
     */
    Member getByAccount(String account);
}
