package cn.cpoet.yunzhi.note.web.comm.vo;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperties;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

import java.util.HashMap;

/**
 * @author CPoet
 */
@Data
@Schema(title = "I18n(K-V)对象")
@SchemaProperties({
    @SchemaProperty(name = "key", schema = @Schema(title = "键名")),
    @SchemaProperty(name = "value", schema = @Schema(title = "值"))
})
public class I18nMapVO extends HashMap<String, String> {
    /**
     * 空实例，不可操作
     */
    public final static I18nMapVO EMPTY = new I18nMapVO();

    @Hidden
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
}
