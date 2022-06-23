package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 人员分组
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_group")
public class Group extends BaseModel {
}
