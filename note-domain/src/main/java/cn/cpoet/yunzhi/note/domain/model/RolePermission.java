package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseRecordModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_role_permission")
public class RolePermission extends BaseRecordModel {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id
     */
    private Long permissionId;
}
