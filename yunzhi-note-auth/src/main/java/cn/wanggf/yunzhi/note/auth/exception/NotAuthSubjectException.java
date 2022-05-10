package cn.wanggf.yunzhi.note.auth.exception;

/**
 * 不存在认证异常
 *
 * @author wanggf
 */
public class NotAuthSubjectException extends AuthException {
    public NotAuthSubjectException(String msg) {
        super(msg);
    }

    public NotAuthSubjectException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
