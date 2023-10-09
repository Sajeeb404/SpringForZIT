package com.example.springBoot_my_ap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//@ControllerAdvice
//public class SuccesResponce {
//
//
//    @ExceptionHandler(DataNotFoundException.class)
//    public ResponseEntity<OkResponse> DataFound( DataNotFoundException ex) {
//        OkResponse okResponse = new OkResponse();
//        okResponse.setStatus_code(HttpStatus.OK.value());
//        okResponse.setStatus("Success");
//        okResponse.setReason(ex.getMessage());
//        okResponse.setData(new ArrayList<>());
//        return ResponseEntity.status(HttpStatus.FOUND)
//                .body(okResponse);
//    }
//
//}
