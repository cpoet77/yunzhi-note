package cn.wanggf.yunzhi.note.auth.exception;

import cn.wanggf.donkey.blog.comm.constant.MostReturnStatus;

/**
 * 角色检查异常
 *
 * @author wanggf
 */
public class RoleCheckException extends AuthException {
    public RoleCheckException(String message) {
        super(MostReturnStatus.PERMISSION_DENIED, message);
    }

    public RoleCheckException(String message, Throwable throwable) {
        super(MostReturnStatus.PERMISSION_DENIED, message, throwable);
    }
}
