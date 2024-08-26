package com.tier3hub.CartWave.service;


import com.tier3hub.CartWave.dto.CreateProductDto;
import com.tier3hub.CartWave.dto.ProductResponse;
import com.tier3hub.CartWave.dto.UpdateProductDto;

public interface ProductService {

    ProductResponse createProduct(CreateProductDto createProductDto);

    ProductResponse updateProduct(UpdateProductDto updateProductDto);

    ProductResponse getProduct(Integer id);

    void deleteProduct(Integer id);
}
