package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 笔记
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_note")
public class Note extends BaseModel {
}
