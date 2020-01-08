package com.vestas.kawit.web_error_handler;

import com.vestas.kawit.web_error_handler.exceptions.FileStorageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    private ResponseEntity<Object> illegalArgumentExceptionOverride(IllegalArgumentException ioe) {
        return new ResponseEntity<>(ioe.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = FileStorageException.class)
    private ModelAndView fileStorageExceptionOverride(FileStorageException fse, RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", fse.getMessage());
        mav.setViewName("moms/error");
        return mav;
    }
}
