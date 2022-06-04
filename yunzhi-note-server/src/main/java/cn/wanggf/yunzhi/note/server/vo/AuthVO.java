package cn.wanggf.yunzhi.note.server.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author wanggf
 */
@Data
@Schema(title = "凭证信息")
public class AuthVO {
    @Schema(title = "身份凭证")
    private String token;
}
