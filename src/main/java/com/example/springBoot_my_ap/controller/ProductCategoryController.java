package com.example.springBoot_my_ap.controller;


import com.example.springBoot_my_ap.exception.ErrorResponse;
import com.example.springBoot_my_ap.model.ProductCategoryModel;

import com.example.springBoot_my_ap.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<ProductCategoryModel> postCategory(@Valid @RequestBody ProductCategoryModel productCategoryModel) {
        try {
            service.save(productCategoryModel);
            return new ResponseEntity<>(productCategoryModel, HttpStatus.CREATED);
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
    public ErrorResponse<ProductCategoryModel> getCategoryById(@PathVariable Long id) {


//        ProductCategoryModel cateList = service.getById(id).get();
//        ProductCategoryModel cateList = service.getById(id).orElseThrow(() -> new DataNotFoundException("Category not found for id: " + id));

//        if (cateList != null) {
//            return new ResponseEntity<>(cateList, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        ProductCategoryModel p = service.getById(id);
        return  new ErrorResponse<>(List.of,200,"success", "Product Catagory Found");
//        try {


            // Create a JSON string representing the success response
//            String successResponse = "{"
//                    + "\"status_code\": 1000,"
//                    + "\"status\": \"Success\","
//                    + "\"reason\": \"OK\","
//                    + "\"data\": {"
//                    + "\"id\": " + cateList.getId() + ","
//                    + "\"English Name\": \"" + cateList.getEnglish_name() + "\","
//                    + "\"Bangla Name\": \"" + cateList.getBangla_name() + "\""
//                    + "\"Sequence Number\": \"" + cateList.getSeuquence_number() + "\""
//                    + "\"Stats\": \"" + cateList.getStatus() + "\""
//                    // Add other fields to the data as needed
//                    + "}"
//                    + "}";

//return cateList;

//            return ResponseEntity.ok(successResponse);
//
//        } catch (DataNotFoundException e) {
//
//            throw new DataNotFoundException(e.getMessage());

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





