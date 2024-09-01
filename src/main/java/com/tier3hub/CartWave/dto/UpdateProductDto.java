package com.tier3hub.CartWave.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductDto {

    @NotBlank(message = "Product id is required")
    private int id;

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Product description is required")
    @Length(min = 5,message = "Product's description must be of atleast 5 characters")
    private String description;

    @NotBlank(message = "Product image is required")
    private String image;

    private double discount;

    @NotBlank(message = "Product price is required")
    private double price;

    private double specialPrice;

    @NotBlank(message = "Product quantity is required")
    private int quantity;

    private int categoryId;

    @NotBlank(message = "Product status is required")
    private boolean status;

    @NotBlank(message = "Product's category is required")
    private int category;

}
