package com.example.owproject.exception.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError {

    private final List<FieldError> fieldErrors = new ArrayList<FieldError>();

    public ValidationError() {
        super();
    }

    public void addFieldError(final String path, final String message) {
        final FieldError error = new FieldError(path, message);
        fieldErrors.add(error);
    }
}
