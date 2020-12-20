package spring.project.closetoU.exception;

public class NoSearchEntityException extends RuntimeException {
    public NoSearchEntityException() {
        super();
    }

    public NoSearchEntityException(String message) {
        super(message);
    }

    public NoSearchEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSearchEntityException(Throwable cause) {
        super(cause);
    }

    public NoSearchEntityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
