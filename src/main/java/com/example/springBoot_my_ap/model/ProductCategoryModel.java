package com.example.springBoot_my_ap.model;

import com.example.springBoot_my_ap.enums.CategoryStatus;
import com.example.springBoot_my_ap.exception.ErrorResponse;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Product_Category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductCategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "English name cannot be null")
    private String english_name;
    @NotNull(message = "Bangla name cannot be null")
    private String bangla_name;


    private Double seuquence_number;

    @Enumerated(EnumType.STRING)
    private CategoryStatus status;

}
