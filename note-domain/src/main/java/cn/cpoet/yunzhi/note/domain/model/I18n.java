package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
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

    @Schema(title = "信息唯一编码")
    @Column(name = "name", unique = true)
    private String name;

    @Schema(title = "使用的场景")
    @Column(name = "scenes", nullable = false)
    private String scenes;

    @Schema(title = "使用分组")
    @Column(name = "group", nullable = false)
    private String group;

    @Schema(title = "状态")
    @Column(name = "status", nullable = false)
    private CommStatus status;

    @Schema(title = "是否内置")
    @Column(name = "is_built_in", nullable = false)
    private Boolean isBuiltIn;
}
