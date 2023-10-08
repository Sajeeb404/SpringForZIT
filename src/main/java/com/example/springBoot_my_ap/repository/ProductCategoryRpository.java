package com.example.springBoot_my_ap.repository;
import com.example.springBoot_my_ap.model.ProductCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRpository extends JpaRepository<ProductCategoryModel,Long> {



}
