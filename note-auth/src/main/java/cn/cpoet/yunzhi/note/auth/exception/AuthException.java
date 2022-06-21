package cn.cpoet.yunzhi.note.auth.exception;

import cn.cpoet.yunzhi.note.api.exception.NoteException;

/**
 * 认证异常
 *
 * @author CPoet
 */
public class AuthException extends NoteException {
    public AuthException(String message) {
        super(message);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
