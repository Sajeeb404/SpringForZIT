package com.example.springBoot_my_ap.repository;
import com.example.springBoot_my_ap.model.ProductCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRpository extends JpaRepository<ProductCategoryModel,Long> {


//    this method for sequence number auto increment
    @Query("SELECT MAX(p.seuquence_number) FROM ProductCategoryModel p")
    Double findMaxSequenceNumber();

}
