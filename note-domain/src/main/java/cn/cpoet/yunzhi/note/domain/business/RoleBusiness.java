package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.Role;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class RoleBusiness extends BaseBusiness<Role> {
    protected RoleBusiness(Database server) {
        super(Role.class, server);
    }
}
