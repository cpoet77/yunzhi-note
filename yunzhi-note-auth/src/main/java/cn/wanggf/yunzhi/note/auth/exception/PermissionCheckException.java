package cn.wanggf.yunzhi.note.auth.exception;

/**
 * 权限检查异常
 *
 * @author wanggf
 */
public class PermissionCheckException extends AuthException {
    public PermissionCheckException(String msg) {
        super(msg);
    }

    public PermissionCheckException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
