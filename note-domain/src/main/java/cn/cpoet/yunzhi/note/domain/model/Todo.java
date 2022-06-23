package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 待办
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_todo")
public class Todo extends BaseModel {
}
