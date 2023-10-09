package com.example.springBoot_my_ap.exception;


import com.example.springBoot_my_ap.model.ProductCategoryModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ErrorResponse <T>{


    private int status_code;
    private String status;
    private String reason;
    private List<T> data;


}

