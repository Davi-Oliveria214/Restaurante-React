package com.davi.restaurante.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioException extends RestauranteException {
    public UsuarioException() {
        super("Erro ao validar usuário", HttpStatus.BAD_REQUEST);
    }

    public UsuarioException(String message) {
        super(message, HttpStatus.CONFLICT);
    }

    public UsuarioException(String message, HttpStatus status) {
        super(message, status);
    }
}
