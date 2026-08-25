package com.davi.restaurante.exceptions;

import org.springframework.http.HttpStatus;

public class PratoException extends RestauranteException {
    public PratoException() {
        super("Nenhum prato encontrado");
    }

    public PratoException(String message, HttpStatus status) {
        super(message, status);
    }

    public PratoException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
