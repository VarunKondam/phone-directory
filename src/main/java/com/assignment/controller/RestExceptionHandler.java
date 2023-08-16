package com.assignment.controller;

import com.assignment.exception.NoDataFoundException;
import com.assignment.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {
    @ExceptionHandler(value = {NoDataFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(NoDataFoundException exception, WebRequest request) {
        log.error("Failed to find the requested element", exception);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        errorResponse.setStatus(String.valueOf((HttpStatus.INTERNAL_SERVER_ERROR.value())));
        errorResponse.setTrace(exception.getStackTrace().toString());
        errorResponse.setMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
