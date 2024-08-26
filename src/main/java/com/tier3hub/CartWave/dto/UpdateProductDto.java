package com.tier3hub.CartWave.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductDto {

    private int id;
    private String name;
    private String description;
    private String image;
    private double specialPrice;
    private double price;
    private double discount;
    private int quantity;
    private int category;
    private boolean status;

}
