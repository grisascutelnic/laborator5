package com.example.laborator5.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class NotFoundError extends RuntimeException{
    private String message;
    private HttpStatus status = HttpStatus.NOT_FOUND;

    public NotFoundError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public HttpStatus getStatus() {
        return this.status;
    }
}
