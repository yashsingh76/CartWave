package com.tier3hub.CartWave.service.impl;

import com.tier3hub.CartWave.dto.CategoryResponseDto;
import com.tier3hub.CartWave.dto.CreateCategoryDto;
import com.tier3hub.CartWave.dto.UpdateCategoryDto;
import com.tier3hub.CartWave.entities.Category;
import com.tier3hub.CartWave.exception.ResourceNotFoundException;
import com.tier3hub.CartWave.repositories.CategoryRepo;
import com.tier3hub.CartWave.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponseDto createCategory(CreateCategoryDto createCategoryDto) {
        Category category = modelMapper.map(createCategoryDto, Category.class);
        category.setCreatedAt(LocalDate.now());
        Category save = categoryRepo.save(category);
        return modelMapper.map(save, CategoryResponseDto.class);
    }

    @Override
    public CategoryResponseDto updateCategory(UpdateCategoryDto updateCategoryDto, Integer id) {
        Category category = categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category not found",id));
        category.setName(updateCategoryDto.getName());
        category.setDescription(updateCategoryDto.getDescription());
        category.setImage(updateCategoryDto.getImage());
        category.setUpdatedAt(LocalDate.now());
        categoryRepo.save(category);
        return modelMapper.map(category, CategoryResponseDto.class);
    }

    @Override
    public CategoryResponseDto getCategory(Integer id) {
        Category category = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category not found",id));
        return modelMapper.map(category, CategoryResponseDto.class);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category not found",id));
        categoryRepo.delete(category);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryResponseDto> catDto = categories.stream().map((cat)-> modelMapper.map(cat, CategoryResponseDto.class)).collect(Collectors.toList());
        return catDto;
    }
}
