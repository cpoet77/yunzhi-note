package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import cn.cpoet.yunzhi.note.domain.constant.CompatibleDbTypes;
import cn.cpoet.yunzhi.note.domain.constant.DbLenConst;
import cn.cpoet.yunzhi.note.domain.constant.PermissionType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * RBAC - 权限
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_permission")
public class Permission extends BaseModel {
    /**
     * 父级ID
     */
    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    /**
     * 编码，用于资源权限判断
     */
    @Column(name = "code", unique = true, nullable = false)
    private String code;

    /**
     * 资源名称
     */
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /**
     * 资源图标
     */
    @Column(name = "icon", length = DbLenConst.URL)
    private String icon;

    /**
     * 资源说明介绍
     */
    @Column(name = "description", columnDefinition = CompatibleDbTypes.TEXT)
    private String description;

    /**
     * 是否内置
     */
    @Column(name = "is_built_in", nullable = false)
    private Boolean isBuiltIn;

    /**
     * 资源状态
     */
    @Column(name = "status", nullable = false)
    private CommStatus status;

    /**
     * 排序
     */
    @Column(name = "sorted", nullable = false)
    private Integer sorted;

    /**
     * 资源类型
     */
    @Column(name = "type", nullable = false)
    private PermissionType type;
}
