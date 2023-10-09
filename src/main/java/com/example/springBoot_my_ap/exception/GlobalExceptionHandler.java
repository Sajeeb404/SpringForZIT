package com.example.springBoot_my_ap.exception;

import com.example.springBoot_my_ap.model.ProductCategoryModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException ex) {
        ErrorResponse<ProductCategoryModel> errorResponse = new ErrorResponse();
        errorResponse.setStatus_code(HttpStatus.NOT_FOUND.value());
        errorResponse.setStatus("Failed");
        errorResponse.setReason(ex.getMessage());
        errorResponse.setData(new ArrayList<>());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }



}
