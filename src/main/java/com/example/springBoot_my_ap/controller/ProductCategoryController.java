package com.example.springBoot_my_ap.controller;


import com.example.springBoot_my_ap.exception.ResponseMassage;
import com.example.springBoot_my_ap.exception.ResponseNee;
import com.example.springBoot_my_ap.model.ProductCategoryModel;

import com.example.springBoot_my_ap.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProductCategoryController {


    @Autowired
    ProductCategoryService service;


    @PostMapping("/post")
    public ResponseEntity<ResponseMassage<ProductCategoryModel>> postCategory(@Valid @RequestBody ProductCategoryModel productCategoryModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.add(fieldError.getDefaultMessage());
            }
            ResponseMassage<ProductCategoryModel> responseMessage = new ResponseMassage<>(
                    HttpStatus.BAD_REQUEST.value(),
                    HttpStatus.BAD_REQUEST.getReasonPhrase(),
                    "Invalid data provided",
                    null
            );
            responseMessage.setErrors(errors);

            return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
        }

        List<ProductCategoryModel> data = new ArrayList<>();
        data.add(service.save(productCategoryModel));
        ResponseMassage<ProductCategoryModel> responseMessage = new ResponseMassage<>(
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED.getReasonPhrase(),
                "Category saved successfully",
                data
        );
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }
//this is post api end




//this is get al data api start
        @GetMapping("/get")
    public ResponseEntity<List<ProductCategoryModel>> getAllCategory() {
        try {
            List<ProductCategoryModel> categoryList = new ArrayList<>();
            service.getAllss().forEach(categoryList::add);
            if (categoryList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//this is get al data api end





//this get api by id start
    @GetMapping("/getById/{id}")
    public ResponseEntity<Map<String, Object>> getCategoryById(@PathVariable Long id) {
        String categoryId = id.toString();
        return  service.getById(categoryId);
    }
//this get api by id end




//this is delete api by id start
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ResponseNee> deleteEmployee(@PathVariable Long id) {
        try {
            boolean deleteId =   service.deleteCategory(id);
            if (deleteId){
                ResponseNee rm = new ResponseNee(HttpStatus.OK.value(), "Success", "Category Deleted Successfully");
                return new ResponseEntity<>(rm, HttpStatus.OK);
            }else {
                ResponseNee rn = new ResponseNee(HttpStatus.NOT_FOUND.value(),"Not Found", "Category not found");
                return new ResponseEntity<>(rn, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            ResponseNee responseNee = new ResponseNee(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", e.getMessage());
            return new ResponseEntity<>(responseNee, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//this is delete api by id end




}





