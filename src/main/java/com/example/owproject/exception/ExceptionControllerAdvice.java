package com.example.owproject.exception;

import com.example.owproject.exception.dto.ApiError;
import com.example.owproject.exception.dto.ValidationError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ValidationException.class })
    public ResponseEntity<Void> handleValidationException(ValidationException e) {

        log.error(getErrorMessage(e));

        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = { RuntimeException.class })
    public ResponseEntity<Void> handleRuntimeException(RuntimeException e) {

        log.error(getErrorMessage(e));

        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Void> handleException(Exception e) {

        log.error(getErrorMessage(e));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleMethodArgumentNotValid: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        ApiError apiError = createApiError(status, ex);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleMethodArgumentNotValid: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        ValidationError dto = createValidationError(fieldErrors);

        return handleExceptionInternal(ex, dto, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleHttpMediaTypeNotSupported: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        ApiError apiError = createApiError(status, ex);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleHttpRequestMethodNotSupported: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        pageNotFoundLogger.warn(ex.getMessage());

        Set<HttpMethod> supportedMethods = ex.getSupportedHttpMethods();
        if (!CollectionUtils.isEmpty(supportedMethods)) {
            headers.setAllow(supportedMethods);
        }

        ApiError apiError = createApiError(status, ex);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleHttpMediaTypeNotAcceptable: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        ApiError apiError = createApiError(status, ex);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleMissingPathVariable: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        ApiError apiError = createApiError(status, ex);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleMissingServletRequestParameter: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        ApiError apiError = createApiError(status, ex);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleServletRequestBindingException: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        ApiError apiError = createApiError(status, ex);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleConversionNotSupported: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        ApiError apiError = createApiError(status, ex);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleTypeMismatch: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        ApiError apiError = createApiError(status, ex);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleHttpMessageNotWritable: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        ApiError apiError = createApiError(status, ex);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleMissingServletRequestPart: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        ApiError apiError = createApiError(status, ex);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleBindException: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        ApiError apiError = createApiError(status, ex);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("{} handleNoHandlerFoundException: {}", status.value(), ex.getMessage());
        if (log.isDebugEnabled()) {
            ex.printStackTrace();
        }

        ApiError apiError = createApiError(status, ex);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    private String getErrorMessage(Throwable cause) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        cause.printStackTrace(new PrintStream(baos));

        return baos.toString();
    }

    private ValidationError createValidationError(List<FieldError> fieldErrors) {
        ValidationError dto = new ValidationError();

        for (FieldError fieldError : fieldErrors) {
            String localizedErrorMessage = fieldError.getDefaultMessage();
            dto.addFieldError(fieldError.getField(), localizedErrorMessage);
        }

        return dto;
    }

    private ApiError createApiError(HttpStatus httpStatus, Exception ex) {
        String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage();
        String exceptionName = ex.getClass().getSimpleName();

        return new ApiError(httpStatus, message, exceptionName);
    }
}
