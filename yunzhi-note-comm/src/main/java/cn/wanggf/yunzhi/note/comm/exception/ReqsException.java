package cn.wanggf.yunzhi.note.comm.exception;

/**
 * 请求异常
 *
 * @author wanggf
 */
public class ReqsException extends YunzhiException {
    public ReqsException(String message) {
        super(message);
    }

    public ReqsException(String message, Throwable cause) {
        super(message, cause);
    }
}
