package cn.wanggf.yunzhi.note.auth.exception;

import cn.wanggf.donkey.blog.comm.constant.MostReturnStatus;

/**
 * 权限检查异常
 *
 * @author wanggf
 */
public class PermissionCheckException extends AuthException {
    public PermissionCheckException(String message) {
        super(MostReturnStatus.PERMISSION_DENIED, message);
    }

    public PermissionCheckException(String message, Throwable throwable) {
        super(MostReturnStatus.PERMISSION_DENIED, message, throwable);
    }
}
