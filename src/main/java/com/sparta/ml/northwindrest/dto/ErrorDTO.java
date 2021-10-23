package com.sparta.ml.northwindrest.dto;

public class ErrorDTO extends DTO{

    final Integer statusCode = 204;
    final String errorMessage = "Your query is valid but there is no content. Please try a different query...";

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
