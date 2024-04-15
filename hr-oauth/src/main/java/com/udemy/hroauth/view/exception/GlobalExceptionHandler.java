package com.udemy.hroauth.view.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException exception) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("message", exception.getMessage());

        ExceptionDetails details = new ExceptionDetails(
                LocalDateTime.now().format(formatter),
                HttpStatus.NOT_FOUND.value(),
                exception.getClass().getSimpleName(),
                errors);

        return new ResponseEntity(details, HttpStatus.NOT_FOUND);
    }
}
