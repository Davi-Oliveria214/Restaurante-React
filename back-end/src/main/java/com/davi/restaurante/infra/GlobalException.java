package com.davi.restaurante.infra;

import com.davi.restaurante.exceptions.RestauranteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RestauranteException.class)
    private ResponseEntity<Object> restauranteException(RestauranteException rex) {
        BodyException body = new BodyException(rex.getStatus(), rex.getMessage());

        return ResponseEntity.status(body.status()).body(body);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> exceptions(Exception exception) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        BodyException body = new BodyException(status, exception.getMessage());

        return ResponseEntity.status(body.status()).body(body);
    }
}