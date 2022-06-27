package cn.cpoet.yunzhi.note.web.comm.constant;

import cn.cpoet.yunzhi.note.api.constant.Status;
import lombok.RequiredArgsConstructor;

/**
 * @author CPoet
 */
@RequiredArgsConstructor
public enum ReqsStatus implements Status {
    /**
     * 登录失败
     */
    LOGIN_FAILED(2000, "登录失败"),

    /**
     * 账号或者密码错误
     */
    ACCOUNT_PASS_ERROR(2001, "账号或者密码错误"),

    /**
     * 账号锁定
     */
    MEMBER_LOCKED(2002, "账号锁定"),

    /**
     * 用户已禁用
     */
    MEMBER_DISABLED(2003, "用户已禁用"),

    /**
     * 账号过期
     */
    MEMBER_EXPIRED(2004, "账号过期");

    private final int code;
    private final String msg;

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return msg;
    }
}
