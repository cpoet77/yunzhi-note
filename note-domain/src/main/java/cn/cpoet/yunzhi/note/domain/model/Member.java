package cn.cpoet.yunzhi.note.domain.model;

import cn.cpoet.yunzhi.note.domain.base.BaseModel;
import cn.cpoet.yunzhi.note.domain.constant.CommStatus;
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
@Table(name = "sys_member")
public class Member extends BaseModel {
    /**
     * 用户姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 昵称
     */
    @Column(name = "nickName")
    private String nickName;

    /**
     * 用户账号
     */
    @Column(name = "account")
    private String account;

    /**
     * 密码摘要
     */
    @Column(name = "password")
    private String password;

    /**
     * 密码摘要盐值
     */
    @Column(name = "salt")
    private String salt;

    /**
     * 用户组id
     */
    @Column(name = "group_id")
    private Long groupId;

    /**
     * 个人简介
     */
    @Column(name = "summary", length = 512)
    private String summary;

    /**
     * 账号是否锁定
     */
    @Column(name = "locked")
    private Boolean locked;

    /**
     * 状态
     */
    @Column(name = "status")
    private CommStatus status;

    /**
     * 账号过期时间
     */
    @Column(name = "expired_time")
    private LocalDateTime expiredTime;
}
