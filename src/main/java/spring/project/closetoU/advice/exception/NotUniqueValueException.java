package spring.project.closetoU.advice.exception;

public class NotUniqueValueException extends RuntimeException{
    public NotUniqueValueException() {
        super();
    }

    public NotUniqueValueException(String message) {
        super(message);
    }

    public NotUniqueValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotUniqueValueException(Throwable cause) {
        super(cause);
    }

    protected NotUniqueValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
