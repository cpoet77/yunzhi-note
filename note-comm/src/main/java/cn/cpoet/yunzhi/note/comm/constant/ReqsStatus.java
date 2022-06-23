package cn.cpoet.yunzhi.note.comm.constant;

import lombok.RequiredArgsConstructor;

/**
 * 常用状态定义
 *
 * @author CPoet
 */
@RequiredArgsConstructor
public enum ReqsStatus implements Status {
    /**
     * OK
     */
    SUCCESS(0, "success"),

    /**
     * 系统错误
     */
    SYS_ERROR(2500, "系统错误");

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
