package com.tier3hub.CartWave.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryDto {

    @NotBlank(message = "Category name is required")
    private String name;

    @NotBlank(message = "Category description is required")
    private String description;

    @NotBlank(message = "Catgeory image is required")
    private String image;

    private Boolean status;

}
