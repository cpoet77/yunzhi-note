package cn.cpoet.yunzhi.note.domain.business;

import cn.cpoet.yunzhi.note.domain.base.BaseBusiness;
import cn.cpoet.yunzhi.note.domain.base.Business;
import cn.cpoet.yunzhi.note.domain.model.RolePermission;
import io.ebean.Database;

/**
 * @author CPoet
 */
@Business
public class RolePermissionBusiness extends BaseBusiness<RolePermission> {
    protected RolePermissionBusiness(Database server) {
        super(RolePermission.class, server);
    }
}
