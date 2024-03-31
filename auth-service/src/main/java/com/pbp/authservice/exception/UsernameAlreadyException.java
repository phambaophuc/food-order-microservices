package com.pbp.authservice.exception;

import java.io.Serial;

public class UsernameAlreadyException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public UsernameAlreadyException() {
        super();
    }

    public UsernameAlreadyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameAlreadyException(String message) {
        super(message);
    }

    public UsernameAlreadyException(Throwable cause) {
        super(cause);
    }
}
