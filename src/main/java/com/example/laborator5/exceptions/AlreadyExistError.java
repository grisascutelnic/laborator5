package com.example.laborator5.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyExistError extends RuntimeException{
    private String message;
    private HttpStatus status = HttpStatus.CONFLICT;

    public AlreadyExistError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
