package com.example.ananasstore.exception;

import com.example.ananasstore.dto.ResponseAPI;
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

    //handle AppException
    @ExceptionHandler(value = AppException.class)
    ResponseAPI<String> handleException(AppException exception) {
        return new ResponseAPI<>(
                exception.getErrorCode().getCode(),
                exception.getMessage()
        );
    }

}
