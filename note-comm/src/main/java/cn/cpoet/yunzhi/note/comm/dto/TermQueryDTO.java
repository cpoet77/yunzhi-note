package cn.cpoet.yunzhi.note.comm.dto;

import cn.cpoet.yunzhi.note.comm.support.HideHashMap;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperties;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;

/**
 * @author CPoet
 */
@Data
@Schema(title = "简单条件查询")
@SchemaProperties({
    @SchemaProperty(name = "key", schema = @Schema(title = "字段名", implementation = String.class)),
    @SchemaProperty(name = "value", schema = @Schema(title = "条件", implementation = TermQueryDTO.Term.class))
})
public class TermQueryDTO extends HideHashMap<String, TermQueryDTO.Term> {
    @Data
    @Schema(title = "查询条件")
    public final static class Term {
        @Schema(title = "搜索关键字")
        private String search;

        @Schema(title = "排序")
        private String order;
    }
}
