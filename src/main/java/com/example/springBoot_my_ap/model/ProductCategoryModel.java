package com.example.springBoot_my_ap.model;

import com.example.springBoot_my_ap.enums.CategoryStatus;
import lombok.*;
import javax.persistence.*;

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

    private String english_name;
    private String bangla_name;
    private String seuquence_number;

    @Enumerated(EnumType.STRING)
    private CategoryStatus status;

}
