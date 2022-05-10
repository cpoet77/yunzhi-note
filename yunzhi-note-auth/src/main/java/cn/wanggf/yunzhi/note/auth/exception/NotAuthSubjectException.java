package cn.wanggf.yunzhi.note.auth.exception;

import cn.wanggf.donkey.blog.comm.constant.MostReturnStatus;

/**
 * 不存在认证异常
 *
 * @author wanggf
 */
public class NotAuthSubjectException extends AuthException {
    public NotAuthSubjectException(String message) {
        super(MostReturnStatus.NOT_LOGIN, message);
    }

    public NotAuthSubjectException(String message, Throwable throwable) {
        super(MostReturnStatus.NOT_LOGIN, message, throwable);
    }
}
