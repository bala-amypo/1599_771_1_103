package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntime(RuntimeException ex) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = ex.getMessage().toLowerCase();

        if (message.contains("exists")) {
            status = HttpStatus.BAD_REQUEST;
        } else if (message.contains("after")) {
            status = HttpStatus.BAD_REQUEST;
        } else if (message.contains("not found")) {
            status = HttpStatus.NOT_FOUND;
        } else if (message.contains("must") || message.contains("invalid")) {
            status = HttpStatus.BAD_REQUEST;
        }

        ErrorResponse response = new ErrorResponse(
                ex.getMessage(),
                status.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, status);
    }
}
