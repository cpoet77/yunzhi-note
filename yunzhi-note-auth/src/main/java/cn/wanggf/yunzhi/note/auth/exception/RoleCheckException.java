package cn.wanggf.yunzhi.note.auth.exception;

/**
 * 角色检查异常
 *
 * @author wanggf
 */
public class RoleCheckException extends AuthException {
    public RoleCheckException(String msg) {
        super(msg);
    }

    public RoleCheckException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
