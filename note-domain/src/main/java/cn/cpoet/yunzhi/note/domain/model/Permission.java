package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import lombok.Data;

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
}
