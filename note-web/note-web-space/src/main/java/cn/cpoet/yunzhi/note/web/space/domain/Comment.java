package cn.cpoet.yunzhi.note.web.space.domain;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author CPoet
 */
@Data
@Entity
@Table(name = "spc_comment")
public class Comment extends BaseModel {
}
