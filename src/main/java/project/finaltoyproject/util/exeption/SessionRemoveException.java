package project.finaltoyproject.util.exeption;

public class SessionRemoveException extends Exception{
    public SessionRemoveException() {
        super();
    }

    public SessionRemoveException(String message) {
        super(message);
    }

    public SessionRemoveException(String message, Throwable cause) {
        super(message, cause);
    }

    public SessionRemoveException(Throwable cause) {
        super(cause);
    }

    protected SessionRemoveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
