package devandroid.micaela.moldylemons_api.exception;

import org.springframework.http.HttpStatus;

public abstract class AuthException extends RuntimeException {
    private final HttpStatus status;

    public AuthException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}