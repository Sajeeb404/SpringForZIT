package com.example.springBoot_my_ap.exception;

import com.example.springBoot_my_ap.model.ProductCategoryModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseMassage> handleDataNotFoundException(DataNotFoundException ex) {
        ResponseMassage<ProductCategoryModel> errorResponse = new ResponseMassage();
        errorResponse.setStatus_code(HttpStatus.NOT_FOUND.value());
        errorResponse.setStatus("Failed");
        errorResponse.setReason(ex.getMessage());
        errorResponse.setData(new ArrayList<>());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }



}
