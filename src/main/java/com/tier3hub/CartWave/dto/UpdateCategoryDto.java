package com.tier3hub.CartWave.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryDto {


    private int id;

    @NotBlank(message = "Category ame is required")
    private String name;

    @NotBlank(message = "Category description is required")
    private String description;

    @NotBlank(message = "Category image is required")
    private String image;

    private Boolean status;

}
