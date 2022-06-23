package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseRecordModel;
import cn.cpoet.yunzhi.note.domain.constant.DbLenConst;
import cn.cpoet.yunzhi.note.domain.constant.LoginType;
import cn.cpoet.yunzhi.note.domain.constant.LogoutType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 登录日志
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "sys_login_log")
public class LoginLog extends BaseRecordModel {
    /**
     * 用户id
     */
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    /**
     * 登录账号
     */
    @Column(name = "account", nullable = false, length = DbLenConst.ACCOUNT)
    private String account;

    /**
     * 登录类型
     */
    @Column(name = "login_type", nullable = false)
    private LoginType loginType;

    /**
     * 登出类型
     */
    @Column(name = "logout_type")
    private LogoutType logoutType;

    /**
     * 登录IP地址
     */
    @Column(name = "ip_addr", length = DbLenConst.IP)
    private String ipAddr;

    /**
     * UA信息
     */
    @Column(name = "user_agent")
    private String userAgent;

    /**
     * 操作系统
     */
    @Column(name = "os")
    private String os;

    /**
     * 分辨率信息
     */
    @Column(name = "screen")
    private String screen;

    /**
     * 登录时间
     */
    @Column(name = "login_time", nullable = false)
    private LocalDateTime loginTime;

    /**
     * 登出时间
     */
    @Column(name = "logout_time")
    private LocalDateTime logoutTime;
}
