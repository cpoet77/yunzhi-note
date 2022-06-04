package cn.wanggf.yunzhi.note.comm.constant;

import lombok.RequiredArgsConstructor;

/**
 * 常用状态定义
 *
 * @author wanggf
 */
@RequiredArgsConstructor
public enum CommStatus implements Status {
    SUCCESS(0, "success");

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
