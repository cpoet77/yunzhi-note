package cn.wanggf.yunzhi.note.auth.exception;

import cn.wanggf.donkey.blog.comm.constant.MostReturnStatus;

/**
 * 认证检查异常
 *
 * @author wanggf
 */
public class AuthCheckException extends AuthException {
    public AuthCheckException(String message) {
        super(MostReturnStatus.ACCESS_DENIED, message);
    }

    public AuthCheckException(String message, Throwable throwable) {
        super(MostReturnStatus.ACCESS_DENIED, message, throwable);
    }
}
