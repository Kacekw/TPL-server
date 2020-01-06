package com.vestas.kawit.task_lists.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    private ResponseEntity<Object> illegalArgumentExceptionOverride(IllegalArgumentException ioe) {
        return new ResponseEntity<>(ioe.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
