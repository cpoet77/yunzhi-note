package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import cn.cpoet.yunzhi.note.domain.constant.CompatibleDbTypes;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * RBAC - 角色
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_role")
public class Role extends BaseModel {
    /**
     * 角色编码
     */
    @Column(name = "code", unique = true, nullable = false)
    private String code;

    /**
     * 角色名称
     */
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /**
     * 排序
     */
    @Column(name = "sorted", nullable = false)
    private Integer sorted;

    /**
     * 介绍
     */
    @Column(name = "description", columnDefinition = CompatibleDbTypes.TEXT)
    private String description;

    /**
     * 状态
     */
    @Column(name = "status", nullable = false)
    private CommStatus status;

    /**
     * 是否系统内置
     */
    @Column(name = "is_built_in", nullable = false)
    private Boolean isBuiltIn;
}
