package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404 - NOT FOUND
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message", ex.getMessage());
        response.put("status", 404);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // 400 - BAD REQUEST (exists, after, must, invalid)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequest(RuntimeException ex) {

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message", ex.getMessage());

        if (ex.getMessage().contains("exists")
                || ex.getMessage().contains("after")
                || ex.getMessage().contains("must")
                || ex.getMessage().contains("invalid")) {

            response.put("status", 400);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        // fallback
        response.put("status", 500);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
