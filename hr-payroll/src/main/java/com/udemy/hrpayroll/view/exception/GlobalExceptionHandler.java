package com.udemy.hrpayroll.view.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    @ExceptionHandler(FeignException.class)
    public ResponseEntity handleFeignException(FeignException exception) {
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
