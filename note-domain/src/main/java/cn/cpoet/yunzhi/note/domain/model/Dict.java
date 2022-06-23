package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 字典
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_dict")
public class Dict extends BaseModel {
}
