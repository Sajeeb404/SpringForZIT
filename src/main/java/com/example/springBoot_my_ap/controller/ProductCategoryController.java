package com.example.springBoot_my_ap.controller;


import com.example.springBoot_my_ap.exception.DataNotFoundException;
import com.example.springBoot_my_ap.exception.ErrorResponse;
import com.example.springBoot_my_ap.model.ProductCategoryModel;

import com.example.springBoot_my_ap.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProductCategoryController {


    @Autowired
    ProductCategoryService service;



//this is post api start
     @PostMapping("/postCategory")
    public ResponseEntity<Map<String, Object>> postCategory(@Valid @RequestBody ProductCategoryModel productCategoryModel, ErrorResponse err) {
         Map<String, Object> response = new HashMap<>();
         response.put("message", err);
         response.put("data", productCategoryModel);
        try {
            return ResponseEntity.ok(response);
//            service.save(productCategoryModel);
//            return new ResponseEntity<>(productCategoryModel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
//this is post api end



//this is get al data api start
        @GetMapping("/getAllCategory")
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
    @GetMapping("/getCategoryById/{id}")
    public ResponseEntity<Map<String, Object>> getCategoryById(@PathVariable Long id) {
        String categoryId = id.toString();
        return  service.getById(categoryId);
    }


//this get api by id end




//this is delete api by id start
    @DeleteMapping("/deleteCategoryById/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
        try {
            service.deleteCategory(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//this is delete api by id end




}





