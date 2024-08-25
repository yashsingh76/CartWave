package com.tier3hub.CartWave.service;

import com.tier3hub.CartWave.dto.CategoryResponseDto;
import com.tier3hub.CartWave.dto.CreateCategoryDto;
import com.tier3hub.CartWave.dto.UpdateCategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto createCategory(CreateCategoryDto createCategoryDto);

    CategoryResponseDto updateCategory(UpdateCategoryDto updateCategoryDto, Integer id);

    CategoryResponseDto getCategory(Integer id);

    void deleteCategory(Integer id);

    List<CategoryResponseDto> getAllCategories();
}
