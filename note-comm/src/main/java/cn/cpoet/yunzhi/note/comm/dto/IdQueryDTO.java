package cn.cpoet.yunzhi.note.comm.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Id查询Dto
 *
 * @author CPoet
 */
@Data
@Schema(title = "Id查询")
@NoArgsConstructor
@AllArgsConstructor
public class IdQueryDTO {

    @Schema(title = "实体id")
    @NotNull(message = "实体Id不能为空")
    private Long id;
}
