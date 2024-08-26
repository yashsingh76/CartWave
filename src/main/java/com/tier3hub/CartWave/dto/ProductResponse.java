package com.tier3hub.CartWave.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private int id;
    private String name;
    private String description;
    private String image;
    private double discount;
    private double price;
    private double specialPrice;
    private int quantity;
    private int category;
    private boolean status;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
