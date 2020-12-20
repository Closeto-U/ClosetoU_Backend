package spring.project.closetoU.exception;

public class NoUniqueEmailException extends RuntimeException{
    public NoUniqueEmailException() {
        super();
    }

    public NoUniqueEmailException(String message) {
        super(message);
    }

    public NoUniqueEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoUniqueEmailException(Throwable cause) {
        super(cause);
    }

    protected NoUniqueEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
