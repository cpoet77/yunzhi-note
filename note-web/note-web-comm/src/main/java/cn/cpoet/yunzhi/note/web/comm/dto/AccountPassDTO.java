package cn.cpoet.yunzhi.note.web.comm.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author CPoet
 */
@Data
@Schema(title = "用户名密码信息")
public class AccountPassDTO {
    @Schema(title = "账号")
    @NotEmpty(message = "账号不能为空")
    private String account;

    @Schema(title = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @Schema(title = "验证码")
    private String captcha;
}
