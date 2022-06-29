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
@Schema(title = "国际化I18n")
@Table(name = "sys_i18n")
public class I18n extends BaseModel {
}
