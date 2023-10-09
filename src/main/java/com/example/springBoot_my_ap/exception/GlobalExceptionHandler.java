package com.example.springBoot_my_ap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(HttpServletRequest request, DataNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus_code(HttpStatus.NOT_FOUND.value());
        errorResponse.setStatus("Failed");
        errorResponse.setReason(ex.getMessage());
        errorResponse.setData(new ArrayList<>());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }



}