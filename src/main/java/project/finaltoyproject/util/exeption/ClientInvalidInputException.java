package project.finaltoyproject.util.exeption;

public class ClientInvalidInputException extends Exception{
    public ClientInvalidInputException() {
        super();
    }

    public ClientInvalidInputException(String message) {
        super(message);
    }

    public ClientInvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientInvalidInputException(Throwable cause) {
        super(cause);
    }

    protected ClientInvalidInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
