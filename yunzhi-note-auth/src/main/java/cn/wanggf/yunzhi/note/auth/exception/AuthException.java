package cn.wanggf.yunzhi.note.auth.exception;

/**
 * 认证异常
 *
 * @author wanggf
 */
public class AuthException extends RuntimeException {
    public AuthException(String msg) {
        super(msg);
    }

    public AuthException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
