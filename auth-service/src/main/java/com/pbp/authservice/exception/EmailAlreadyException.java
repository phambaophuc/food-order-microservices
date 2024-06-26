package com.pbp.authservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.CONFLICT)
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
