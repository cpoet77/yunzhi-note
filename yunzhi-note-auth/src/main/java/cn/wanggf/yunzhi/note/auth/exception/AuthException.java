package cn.wanggf.yunzhi.note.auth.exception;

import cn.wanggf.yunzhi.note.comm.exception.YunzhiException;

/**
 * 认证异常
 *
 * @author wanggf
 */
public class AuthException extends YunzhiException {
    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
