package com.pbp.authservice.exception;

import java.io.Serial;

public class EmailAlreadyException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public EmailAlreadyException() {
        super();
    }

    public EmailAlreadyException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailAlreadyException(String message) {
        super(message);
    }

    public EmailAlreadyException(Throwable cause) {
        super(cause);
    }
}
