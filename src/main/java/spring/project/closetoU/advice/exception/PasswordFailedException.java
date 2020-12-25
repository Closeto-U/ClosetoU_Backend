package spring.project.closetoU.advice.exception;

public class PasswordFailedException extends RuntimeException{
    public PasswordFailedException() {
    }

    public PasswordFailedException(String message) {
        super(message);
    }

    public PasswordFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordFailedException(Throwable cause) {
        super(cause);
    }

    public PasswordFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
