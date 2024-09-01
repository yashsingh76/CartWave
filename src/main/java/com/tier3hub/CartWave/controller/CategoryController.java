package com.tier3hub.CartWave.controller;

import com.tier3hub.CartWave.dto.CategoryResponseDto;
import com.tier3hub.CartWave.dto.CreateCategoryDto;
import com.tier3hub.CartWave.dto.UpdateCategoryDto;
import com.tier3hub.CartWave.service.CategoryService;
import com.tier3hub.CartWave.utils.AppConstants;
import com.tier3hub.CartWave.utils.ResponseHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/admin/create")
    public ResponseEntity<Object> createCategory(@Valid @RequestBody CreateCategoryDto createCategoryDto) {
        CategoryResponseDto category = categoryService.createCategory(createCategoryDto);
        return ResponseHandler.generateResponse("Category created successfully", HttpStatus.CREATED, category);
    }

    @PutMapping("/admin/update/{id}")
    public ResponseEntity<Object> updateCategory(@Valid @RequestBody UpdateCategoryDto updateCategoryDto, @PathVariable Integer id){
        CategoryResponseDto category = categoryService.updateCategory(updateCategoryDto,id);
        return ResponseHandler.generateResponse("Category updated successfully",HttpStatus.OK,category);
    }

    @GetMapping("/users/getcategory/{id}")
    public ResponseEntity<Object> getCategory(@PathVariable Integer id){
        CategoryResponseDto category = categoryService.getCategory(id);
        return ResponseHandler.generateResponse("Category fetched successfully",HttpStatus.FOUND,category);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return ResponseHandler.generateResponse("Category deleted successfully",HttpStatus.OK,null);
    }

    @GetMapping("/users/getall")
    public ResponseEntity<Object> getAllCategories(
            @RequestParam (name = "pageNumber", defaultValue = AppConstants.pageNumber, required = false) Integer pageNumber,
            @RequestParam (name ="pageSize" ,defaultValue = AppConstants.pageSize, required = false) Integer pageSize,
            @RequestParam (name ="sortBy" , defaultValue = AppConstants.sortBy , required = false) String sortBy,
            @RequestParam (name ="sortOrder" , defaultValue = AppConstants.sortOrder , required = false) String sortOrder
    ){
        List<CategoryResponseDto> categories = categoryService.getAllCategories(pageNumber, pageSize, sortBy, sortOrder);
        return ResponseHandler.generateResponse("Categories fetched successfully",HttpStatus.FOUND,categories);
    }
}
