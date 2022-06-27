package cn.cpoet.yunzhi.note.api.exception;

import cn.cpoet.yunzhi.note.api.constant.Status;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 请求异常
 *
 * @author CPoet
 */
@Getter
public class ReqsException extends NoteException {
    private final Status status;

    public ReqsException(Status status) {
        super(status.message());
        this.status = status;
    }

    public ReqsException(Status status, String message) {
        super(message);
        this.status = new InlineStatus(status.code(), message);
    }

    public ReqsException(Status status, String message, Throwable cause) {
        super(message, cause);
        this.status = new InlineStatus(status.code(), message);
    }

    @ToString
    @RequiredArgsConstructor
    private static class InlineStatus implements Status {
        private final int code;
        private final String message;

        @Override
        public int code() {
            return code;
        }

        @Override
        public String message() {
            return message;
        }
    }
}
