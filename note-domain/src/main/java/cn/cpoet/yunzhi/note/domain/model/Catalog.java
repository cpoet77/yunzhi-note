package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 笔记分类（目录)
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_catalog")
public class Catalog extends BaseModel {
}
