package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import lombok.Data;

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
}
