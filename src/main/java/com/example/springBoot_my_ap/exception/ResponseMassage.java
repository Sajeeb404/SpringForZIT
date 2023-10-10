package com.example.springBoot_my_ap.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ResponseMassage<T>{

    private int status_code;
    private String status;
    private String reason;
    private List<T> data;


    public void setErrors(List<String> errors) {
    }
}

