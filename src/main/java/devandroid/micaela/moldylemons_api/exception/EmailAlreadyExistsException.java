package devandroid.micaela.moldylemons_api.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends AuthException {
    public EmailAlreadyExistsException(String email) {
        super("This email address is already in use: " + email, HttpStatus.CONFLICT);
    }
}