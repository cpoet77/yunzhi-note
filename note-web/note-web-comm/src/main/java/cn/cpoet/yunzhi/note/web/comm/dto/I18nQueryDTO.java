package cn.cpoet.yunzhi.note.web.comm.dto;

import cn.cpoet.yunzhi.note.domain.constant.I18nLocale;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author CPoet
 */
@Data
@Schema(title = "I18n查询")
public class I18nQueryDTO {
    @Schema(title = "使用场景")
    private String scenes;

    @Schema(title = "使用分组")
    private String groupName;

    @Schema(title = "查询区域")
    private I18nLocale locale;
}
