package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseRecordModel;
import cn.cpoet.yunzhi.note.domain.constant.DbLenConst;
import cn.cpoet.yunzhi.note.domain.constant.LoginType;
import cn.cpoet.yunzhi.note.domain.constant.LogoutType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author CPoet
 */
@Data
@Entity
@Schema(title = "登录日志")
@Table(name = "sys_login_log")
public class LoginLog extends BaseRecordModel {
    @Schema(title = "用户id")
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Schema(title = "登录账号")
    @Column(name = "account", nullable = false, length = DbLenConst.ACCOUNT)
    private String account;

    @Schema(title = "登录类型")
    @Column(name = "login_type", nullable = false)
    private LoginType loginType;

    @Schema(title = "登出类型")
    @Column(name = "logout_type")
    private LogoutType logoutType;

    @Schema(title = "登录IP地址")
    @Column(name = "ip_addr", length = DbLenConst.IP)
    private String ipAddr;

    @Schema(title = "UA信息")
    @Column(name = "user_agent")
    private String userAgent;

    @Schema(title = "操作系统")
    @Column(name = "os")
    private String os;

    @Schema(title = "分辨率信息")
    @Column(name = "screen")
    private String screen;

    @Schema(title = "登录时间")
    @Column(name = "login_time", nullable = false)
    private LocalDateTime loginTime;

    @Schema(title = "登出时间")
    @Column(name = "logout_time")
    private LocalDateTime logoutTime;

    @Schema(title = "扩展字段01")
    @Column(name = "ext01")
    private String ext01;

    @Schema(title = "扩展字段02")
    @Column(name = "ext02")
    private String ext02;

    @Schema(title = "扩展字段03")
    @Column(name = "ext03")
    private String ext03;
}
