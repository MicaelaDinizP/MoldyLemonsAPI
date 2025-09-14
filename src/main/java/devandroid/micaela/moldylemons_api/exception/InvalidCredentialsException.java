package devandroid.micaela.moldylemons_api.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends AuthException {
    public InvalidCredentialsException() {
        super("Invalid email or password.", HttpStatus.UNAUTHORIZED);
    }
}