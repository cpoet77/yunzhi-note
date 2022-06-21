package cn.cpoet.yunzhi.note.api.exception;

/**
 * 所有的系统业务异常均转换为非受检异常，未进行显示处理的将由全局异常处理类进行处理
 *
 * @author CPoet
 */
public class NoteException extends RuntimeException {
    public NoteException(String message) {
        super(message);
    }

    public NoteException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoteException(Throwable cause) {
        super(cause);
    }
}
