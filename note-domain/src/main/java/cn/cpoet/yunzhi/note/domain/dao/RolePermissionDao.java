package cn.cpoet.yunzhi.note.domain.dao;

import cn.cpoet.yunzhi.note.domain.base.BaseDao;
import cn.cpoet.yunzhi.note.domain.model.RolePermission;
import io.ebean.Database;
import org.springframework.stereotype.Repository;

/**
 * @author CPoet
 */
@Repository
public class RolePermissionDao extends BaseDao<RolePermission> {
    protected RolePermissionDao(Database server) {
        super(RolePermission.class, server);
    }
}
