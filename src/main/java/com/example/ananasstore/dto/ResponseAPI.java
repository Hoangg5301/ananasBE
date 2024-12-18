package com.example.ananasstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseAPI <T>{
    private String responseMessage;
    private int statusCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Page<T> pageData;

    public ResponseAPI(HttpStatus statusCode, String responseMessage) {
        this.statusCode = statusCode.value();
        this.responseMessage = responseMessage;
    }

    public ResponseAPI(HttpStatus statusCode, String responseMessage, T data) {
        this.statusCode = statusCode.value();
        this.responseMessage = responseMessage;
        this.data = data;
    }

    public ResponseAPI(HttpStatus statusCode, String responseMessage, Page<T> pageData) {
        this.statusCode = statusCode.value();
        this.responseMessage = responseMessage;
        this.pageData = pageData;
    }
}
