package com.example.ananasstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class ResponseAPI <T>{
    private String responseMessage;
    private String statusCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Page<T> pageData;

    public ResponseAPI(String responseMessage, String statusCode) {
        this.responseMessage = responseMessage;
        this.statusCode = statusCode;
    }

    public ResponseAPI(String responseMessage, String statusCode, T data) {
        this.responseMessage = responseMessage;
        this.statusCode = statusCode;
        this.data = data;
    }

    public ResponseAPI(String responseMessage, String statusCode, Page<T> pageData) {
        this.responseMessage = responseMessage;
        this.statusCode = statusCode;
        this.pageData = pageData;
    }
}
