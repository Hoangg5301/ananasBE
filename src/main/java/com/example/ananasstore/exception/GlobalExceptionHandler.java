package com.example.ananasstore.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    //this method handle request field.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException exception) {
        StringBuilder errorMessage = new StringBuilder();
        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            errorMessage.append(fieldError.getDefaultMessage())
            .append(", ")
            .append(fieldError.getField())
            .append(";");
        }
        return ResponseEntity.badRequest().body(errorMessage.toString());
    }

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
