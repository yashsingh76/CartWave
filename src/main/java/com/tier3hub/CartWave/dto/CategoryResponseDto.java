package com.tier3hub.CartWave.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {

    private int id;
    private String name;
    private String description;
    private String image;
    private Boolean status;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
