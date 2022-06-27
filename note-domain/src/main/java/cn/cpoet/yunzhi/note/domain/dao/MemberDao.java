package cn.cpoet.yunzhi.note.domain.dao;

import cn.cpoet.yunzhi.note.domain.base.BaseDao;
import cn.cpoet.yunzhi.note.domain.model.Member;
import cn.cpoet.yunzhi.note.domain.model.query.QMember;
import io.ebean.Database;
import org.springframework.stereotype.Repository;

/**
 * @author CPoet
 */
@Repository
public class MemberDao extends BaseDao<Member> {
    protected MemberDao(Database server) {
        super(Member.class, server);
    }

    /**
     * 根据账号查询
     *
     * @param account 用户账号
     * @return 用户信息
     */
    public Member getByAccount(String account) {
        return new QMember()
            .account.eq(account)
            .findOne();
    }
}
