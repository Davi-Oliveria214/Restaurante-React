package com.davi.restaurante.exceptions;

import org.springframework.http.HttpStatus;

public class RestauranteException extends RuntimeException {
    private final HttpStatus status;

    public RestauranteException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public RestauranteException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}