package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 字典项
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_dict_item")
public class DictItem extends BaseModel {
}
