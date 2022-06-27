package cn.cpoet.yunzhi.note.comm.constant;

import cn.cpoet.yunzhi.note.api.constant.Status;
import lombok.RequiredArgsConstructor;

/**
 * 常用状态定义
 * <div>
 *     状态码说明：
 *     <p>0: 代表成功</p>
 *     <p>-1: 系统级错误/未知错误</p>
 *     <p>1000 - 2000: 公共状态码预留</p>
 *     <p>2000 + : 其它模块自用</p>
 * </div>
 *
 * @author CPoet
 */
@RequiredArgsConstructor
public enum CommReqsStatus implements Status {
    /**
     * OK
     */
    SUCCESS(0, "success"),

    /**
     * 参数校验失败
     */
    PARAMETER_CHECK_FAILED(1000, "参数校验失败"),

    /**
     * 无权访问
     */
    PERMISSION_DENIED(1002, "无权访问"),

    /**
     * 资源不存在
     */
    NONEXISTENT_RESOURCE(1003, "资源不存在"),

    /**
     * 拒绝访问
     */
    ACCESS_DENIED(1004, "拒绝访问"),

    /**
     * 认证失败
     */
    AUTHENTICATION_FAILED(1005, "认证失败"),

    /**
     * 用户未登录
     */
    NOT_LOGIN(1006, "用户未登录"),

    /**
     * 用户状态异常
     */
    USER_STATUS_ERROR(1007, "用户状态异常"),

    /**
     * 无效的请求参数
     */
    INVALID_PARAMETER(1008, "无效的请求参数"),

    /**
     * 系统错误
     */
    SYS_ERROR(-1, "系统错误");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 状态信息
     */
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
