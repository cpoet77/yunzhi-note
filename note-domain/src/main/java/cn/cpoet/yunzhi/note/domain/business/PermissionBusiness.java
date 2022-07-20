package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.Permission;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class PermissionBusiness extends BaseBusiness<Permission> {
    protected PermissionBusiness(Database server) {
        super(Permission.class, server);
    }
}
