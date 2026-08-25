package com.davi.restaurante.infra;

import org.springframework.http.HttpStatus;

public record BodyException(String error, String message, int status) {
    public BodyException(HttpStatus error, String message) {
        this(error.name(), message, error.value());
    }
}