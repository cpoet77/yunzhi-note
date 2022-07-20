package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.Member;
import cn.cpoet.yunzhi.note.domain.model.query.QMember;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class MemberBusiness extends BaseBusiness<Member> {
    protected MemberBusiness(Database server) {
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
