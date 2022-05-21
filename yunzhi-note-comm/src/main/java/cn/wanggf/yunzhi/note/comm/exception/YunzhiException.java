package cn.wanggf.yunzhi.note.comm.exception;

/**
 * 所有业务异常都转换为非受检异常
 *
 * @author wanggf
 */
public class YunzhiException extends RuntimeException {
    public YunzhiException(String message) {
        super(message);
    }

    public YunzhiException(String message, Throwable cause) {
        super(message, cause);
    }
}
