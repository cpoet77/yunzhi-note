package cn.wanggf.yunzhi.note.auth.exception;


/**
 * 认证检查异常
 *
 * @author wanggf
 */
public class AuthCheckException extends AuthException {
    public AuthCheckException(String msg) {
        super(msg);
    }

    public AuthCheckException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
