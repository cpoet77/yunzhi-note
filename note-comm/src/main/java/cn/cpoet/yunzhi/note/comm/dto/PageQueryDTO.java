package cn.cpoet.yunzhi.note.comm.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 分页查询
 *
 * @author CPoet
 */
@Data
@Schema(title = "分页查询")
public class PageQueryDTO {
    @Schema(title = "页码")
    @NotNull(message = "需要指定页码")
    @Size(min = 1, message = "页码不能小于 {min}")
    private Integer pageNo;

    @Schema(title = "每页显示的数据量")
    @NotNull(message = "必须指定每页显示的数量")
    @Size(min = 5, max = 150, message = "每页能显示的数据量在{min}至{max}间")
    private Integer pageSize;
}
