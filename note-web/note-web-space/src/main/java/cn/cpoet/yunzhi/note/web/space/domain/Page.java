package cn.cpoet.yunzhi.note.web.space.domain;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 页面
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "spc_page")
public class Page extends BaseModel {
}
