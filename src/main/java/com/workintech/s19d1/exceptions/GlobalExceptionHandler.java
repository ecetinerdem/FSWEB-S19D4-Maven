package com.workintech.s19d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    public ResponseEntity<ExceptionResponse> handleException(ApiException apiException) {
        log.error("Api exception ocurred " + apiException);
        return new ResponseEntity<>(new ExceptionResponse(apiException.getMessage(), apiException.getHttpStatus().value(), LocalDateTime.now()), apiException.getHttpStatus());
    }

    public ResponseEntity<ExceptionResponse> handleException(Exception exception) {
        log.error("Api exception ocurred " + exception);
        return new ResponseEntity<>(new ExceptionResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
