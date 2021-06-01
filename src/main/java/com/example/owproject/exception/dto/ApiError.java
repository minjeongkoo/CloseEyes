package com.example.owproject.exception.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiError {

    private final int status;
    private final String error;
    private final String message;
    private final String exceptionName;

    public ApiError(final HttpStatus httpStatus, final String message, final String exceptionName) {

        this.status = httpStatus.value();
        this.error = httpStatus.getReasonPhrase();
        this.message = message;
        this.exceptionName = exceptionName;
    }
}
