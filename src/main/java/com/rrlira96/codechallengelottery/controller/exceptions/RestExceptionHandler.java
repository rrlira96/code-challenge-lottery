package com.rrlira96.codechallengelottery.controller.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.rrlira96.codechallengelottery.service.exceptions.InvalidGuessSizeException;
import com.rrlira96.codechallengelottery.service.exceptions.InvalidRangeNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(InvalidRangeNumberException.class)
    public ResponseEntity<StandardError> InvalidRangeNumberHandler(InvalidRangeNumberException exception, HttpServletRequest request) {
        String title = "Invalid number value";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(Instant.now(), status.value(), title, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<StandardError> InvalidFormatExceptionHandler(InvalidFormatException exception, HttpServletRequest request) {
        String title = "Invalid number type";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(Instant.now(), status.value(), title, exception.getLocalizedMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(InvalidGuessSizeException.class)
    public ResponseEntity<StandardError> InvalidGuessSizeExceptionHandler(InvalidGuessSizeException exception, HttpServletRequest request) {
        String title = "Invalid guess";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(Instant.now(), status.value(), title, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

}
