package com.davi.restaurante.exceptions;

import org.springframework.http.HttpStatus;

public class AgendamentoException extends RestauranteException {
    public AgendamentoException() {
        super("Essa data e horário já esta agendado", HttpStatus.BAD_REQUEST);
    }

    public AgendamentoException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

    public AgendamentoException(String message, HttpStatus status) {
        super(message, status);
    }
}
