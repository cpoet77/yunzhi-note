package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.MemberRole;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class MemberRoleBusiness extends BaseBusiness<MemberRole> {
    protected MemberRoleBusiness(Database server) {
        super(MemberRole.class, server);
    }
}
