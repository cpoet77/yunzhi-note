package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author CPoet
 */
@Data
@Entity
@Schema(title = "国际化项")
@Table(name = "sys_i18n_item")
public class I18nItem extends BaseModel {
}
