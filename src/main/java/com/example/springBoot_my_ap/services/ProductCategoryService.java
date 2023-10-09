package com.example.springBoot_my_ap.services;
import com.example.springBoot_my_ap.enums.CategoryStatus;
import com.example.springBoot_my_ap.exception.DataNotFoundException;
import com.example.springBoot_my_ap.model.ProductCategoryModel;
import com.example.springBoot_my_ap.repository.ProductCategoryRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class ProductCategoryService {

    @Autowired
    ProductCategoryRpository repository;


//this method for update and save start
    public void save(ProductCategoryModel productCategoryModel){
        if(productCategoryModel.getId()!=null){
            repository.findById(productCategoryModel.getId()).map(old ->{
                old.setEnglish_name(productCategoryModel.getEnglish_name());
                old.setBangla_name(productCategoryModel.getBangla_name());
                old.setSeuquence_number(productCategoryModel.getSeuquence_number());
                old.setStatus(productCategoryModel.getStatus());
                return repository.save(old);
            });
        }else {
            productCategoryModel.setStatus(CategoryStatus.Active);
           repository.save(productCategoryModel);
        }
    }
//this method for update and save end



//this method for get all data start
    public List<ProductCategoryModel>getAllss(){
        return repository.findAll();
    }
//this method for get all data end



//this method for single category list start
    public ResponseEntity<Map<String, Object>> getById(String id){

        Long categoryId = Long.parseLong(id);
       ProductCategoryModel model = repository.findById(categoryId).orElseThrow(()-> new DataNotFoundException("Category not found "+ id));

        Map<String, Object> response = new TreeMap<>();
        if (model.getId() != null) {
            response.put("data", model);
            response.put("status_code", 200);
            response.put("status", "Success");
            response.put("reason", "Category found " + id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("status_code", 404);
            response.put("status", "Failed");
            response.put("reason", "Category not found " + id);
            response.put("data", new ArrayList<>());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }


    }
//this method for single category list end



//this method for delete by id start
    public void deleteCategory(Long id){
        repository.deleteById(id);
    }
//this method for delete by id end






}
