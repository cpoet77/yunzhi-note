package cn.cpoet.yunzhi.note.web.comm.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户信息
 *
 * @author CPoet
 */
@Data
@Schema(title = "用户基本信息")
public class MemberInfoVO {
    @Schema(title = "用户id")
    private Long id;

    @Schema(title = "用户账号")
    private String account;

    @Schema(title = "昵称")
    private String nickName;

    @Schema(title = "用户组id")
    private Long groupId;

    @Schema(title = "用户组名称")
    private String groupName;

    @Schema(title = "个人简介")
    private String summary;
}
