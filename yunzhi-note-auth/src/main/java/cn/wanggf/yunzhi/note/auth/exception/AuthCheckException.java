package cn.wanggf.yunzhi.note.auth.exception;


/**
 * 认证检查异常
 *
 * @author wanggf
 */
public class AuthCheckException extends AuthException {
    public AuthCheckException(String message) {
        super(message);
    }

    public AuthCheckException(String message, Throwable cause) {
        super(message, cause);
    }
}
