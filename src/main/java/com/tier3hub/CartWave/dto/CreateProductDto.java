package com.tier3hub.CartWave.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {

    @NotBlank(message = "Product name is required")
    @Length(min = 3,message = "Product name of atleast 3 character long")
    private String name;

    @NotBlank(message = "Product image is required")
    private String image;

    @NotBlank(message = "Product description is required")
    @Length(min = 5, message = "Description must be of atleast 5 characters")
    private String description;

    @NotBlank(message = "Product price is required")
    private double price;

    private double specialPrice;

    private double discount;

    @NotBlank(message = "Product quantity is required")
    private int quantity;

    @NotBlank(message = "Product's category is required")
    private int category;

    @NotBlank(message = "Product status is required")
    private boolean status;
}
