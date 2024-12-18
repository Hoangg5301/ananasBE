package com.example.ananasstore.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    //systemError
    APIKEY_INVALID(HttpStatus.FORBIDDEN, "API key is invalid"),
    //userError
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found!"),
    AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED, "Authentication failed!"),
    ;

    ErrorCode(HttpStatus code, String message){
        this.code = code;
        this.message = message;
    }

    private HttpStatus code;
    private String message;
}
