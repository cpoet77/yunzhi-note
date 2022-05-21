package cn.wanggf.yunzhi.note.auth.exception;

/**
 * 认证异常
 *
 * @author wanggf
 */
public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
