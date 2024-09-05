package com.tier3hub.CartWave.service;

import com.tier3hub.CartWave.dto.CreateProductDto;
import com.tier3hub.CartWave.dto.ProductResponse;
import com.tier3hub.CartWave.dto.UpdateProductDto;

import java.util.List;

public interface ProductService{

    ProductResponse addProduct(CreateProductDto createProductDto, Integer id);

    ProductResponse updateProduct(UpdateProductDto updateProductDto);

    void deleteProduct(Integer id);

    ProductResponse getProductById(Integer id);

    List<ProductResponse> getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    List<ProductResponse> getProductByCategory(Integer categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    List<ProductResponse> getProductsByName(String keyword, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
}