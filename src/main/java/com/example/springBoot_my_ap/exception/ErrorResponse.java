package com.example.springBoot_my_ap.exception;


import com.example.springBoot_my_ap.model.ProductCategoryModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor

public class ErrorResponse <T>{

    private List<T> data;
    private int status_code;
    private String status;
    private String reason;
public ErrorResponse(){}

}

