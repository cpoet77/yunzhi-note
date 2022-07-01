package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 用户
 *
 * @author CPoet
 */
@Data
@Entity
@Schema(title = "人员信息")
@Table(name = "sys_member")
public class Member extends BaseModel {
    @Schema(title = "用户姓名")
    @Column(name = "name")
    private String name;

    @Schema(title = "昵称")
    @Column(name = "nickName")
    private String nickName;

    @Schema(title = "用户账号")
    @Column(name = "account", unique = true)
    private String account;

    @Schema(title = "密码摘要")
    @Column(name = "password")
    private String password;

    @Schema(title = "密码摘要盐值")
    @Column(name = "salt")
    private String salt;

    @Schema(title = "用户组id")
    @Column(name = "group_id")
    private Long groupId;

    @Schema(title = "个人简介")
    @Column(name = "summary", length = 512)
    private String summary;

    @Schema(title = "账号是否锁定")
    @Column(name = "locked", nullable = false)
    private Boolean locked;

    @Schema(title = " 状态")
    @Column(name = "status", nullable = false)
    private CommStatus status;

    @Schema(title = "账号过期时间")
    @Column(name = "expired_time", nullable = false)
    private LocalDateTime expiredTime;

    @Schema(title = "是否内置")
    @Column(name = "is_built_in", nullable = false)
    private Boolean isBuiltIn;
}
