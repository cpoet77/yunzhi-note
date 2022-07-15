package cn.cpoet.yunzhi.note.web.comm.vo;

import cn.cpoet.yunzhi.note.comm.support.HideHashMap;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperties;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

/**
 * @author CPoet
 */
@Data
@Schema(title = "I18n(K-V)对象")
@SchemaProperties({
    @SchemaProperty(name = "key", schema = @Schema(title = "键名")),
    @SchemaProperty(name = "value", schema = @Schema(title = "值"))
})
public class I18nMapVO extends HideHashMap<String, String> {
    /**
     * 空实例，不可操作
     */
    public final static I18nMapVO EMPTY = new I18nMapVO();
}
