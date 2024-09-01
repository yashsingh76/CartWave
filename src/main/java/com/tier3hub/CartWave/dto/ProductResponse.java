package com.tier3hub.CartWave.dto;

import com.tier3hub.CartWave.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private int id;
    private String name;
    private String description;
    private String image;
    private double price;
    private double specialPrice;
    private double discount;
    private int quantity;
    private UpdateCategoryDto category;
    //private int category;
    private boolean status;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
