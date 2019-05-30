package by.it.khlystunova.project.java.exceptions;

public class WebsiteException extends RuntimeException {

    public WebsiteException() {
    }

    public WebsiteException(String message) {
        super(message);
    }

    public WebsiteException(Throwable cause) {
        super(cause);
    }

    public WebsiteException(String message, Throwable cause) {
        super(message, cause);
    }
}
