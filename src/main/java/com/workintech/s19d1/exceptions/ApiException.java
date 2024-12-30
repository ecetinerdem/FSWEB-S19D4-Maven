package com.workintech.s19d1.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@Getter
@Setter
public class ApiException extends RuntimeException {
    private HttpStatus httpStatus;

    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
