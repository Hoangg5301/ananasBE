package com.example.ananasstore.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    //systemError
    APIKEY_INVALID(HttpStatus.FORBIDDEN, "API key is invalid"),
    //userError
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found!"),
    ROLE_NOT_FOUND(HttpStatus.NOT_FOUND, "Role not found!"),
    AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED, "Authentication failed!"),
    JWT_INCORRECT(HttpStatus.UNAUTHORIZED, "JWT was expired or incorrect."),
    JWT_EXPIRED(HttpStatus.UNAUTHORIZED, "JWT expired!"),
    UNSUPPORTED_JWT_TOKEN(HttpStatus.UNAUTHORIZED,"Unsupported JWT token!"),
    JWT_INVALID(HttpStatus.UNAUTHORIZED,"JWT token compact of handler are invalid!"),
    ;

    ErrorCode(HttpStatus code, String message){
        this.code = code;
        this.message = message;
    }

    private HttpStatus code;
    private String message;
}
