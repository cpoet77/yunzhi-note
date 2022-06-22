package cn.cpoet.yunzhi.note.comm.exception;

import cn.cpoet.yunzhi.note.api.exception.NoteException;

/**
 * Feign调用异常
 *
 * @author CPoet
 */
public class FeignException extends NoteException {
    public FeignException(String message) {
        super(message);
    }

    public FeignException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeignException(Throwable cause) {
        super(cause);
    }
}
