package com.tier3hub.CartWave.service.impl;

import com.tier3hub.CartWave.dto.CreateProductDto;
import com.tier3hub.CartWave.dto.ProductResponse;
import com.tier3hub.CartWave.dto.UpdateProductDto;
import com.tier3hub.CartWave.entities.Category;
import com.tier3hub.CartWave.entities.Product;
import com.tier3hub.CartWave.exception.ResourceNotFoundException;
import com.tier3hub.CartWave.repositories.CategoryRepo;
import com.tier3hub.CartWave.repositories.ProductRepo;
import com.tier3hub.CartWave.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public ProductResponse createProduct(CreateProductDto createProductDto) {
        Category category = categoryRepo.findById(createProductDto.getCategory()).orElseThrow(()-> new ResourceNotFoundException("Category not found"));
        Product product = modelMapper.map(createProductDto, Product.class);
        product.setCategory(category);
        product.setCreatedAt(LocalDate.now());
        Product save = productRepo.save(product);
        return modelMapper.map(save, ProductResponse.class);
    }

    @Override
    public ProductResponse updateProduct(UpdateProductDto updateProductDto) {
        Category category = categoryRepo.findById(updateProductDto.getCategory()).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        Product product = productRepo.findById(updateProductDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setName(updateProductDto.getName());
        product.setDescription(updateProductDto.getDescription());
        product.setImage(updateProductDto.getImage());
        product.setCategory(category);
        product.setPrice(updateProductDto.getPrice());
        product.setSpecialPrice(updateProductDto.getSpecialPrice());
        product.setQuantity(updateProductDto.getQuantity());
        product.setDiscount(updateProductDto.getDiscount());
        product.setStatus(updateProductDto.isStatus());
        product.setUpdatedAt(LocalDate.now());
        Product save = productRepo.save(product);
        return modelMapper.map(save, ProductResponse.class);
        }

    @Override
    public ProductResponse getProduct(Integer id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepo.delete(product);
    }
}

