package com.example.carfactory.config;

import com.example.carfactory.exception.NotFoundException;
import com.example.carfactory.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(new ApiError(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
