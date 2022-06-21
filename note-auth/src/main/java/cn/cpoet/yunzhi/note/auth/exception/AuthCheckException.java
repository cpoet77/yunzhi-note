package cn.cpoet.yunzhi.note.auth.exception;


/**
 * 认证检查异常
 *
 * @author CPoet
 */
public class AuthCheckException extends AuthException {
    public AuthCheckException(String message) {
        super(message);
    }

    public AuthCheckException(String message, Throwable cause) {
        super(message, cause);
    }
}
