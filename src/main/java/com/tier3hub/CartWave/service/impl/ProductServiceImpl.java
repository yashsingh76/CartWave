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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductResponse addProduct(CreateProductDto createProductDto, Integer id) {
        Category category = categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category is not found"));
        Product product = modelMapper.map(createProductDto, Product.class);
        product.setCategory(category);
        product.setCreatedAt(LocalDate.now());
        Product save = productRepo.save(product);
        return modelMapper.map(save, ProductResponse.class);
    }

    @Override
    public ProductResponse updateProduct(UpdateProductDto updateProductDto) {
        Category category = categoryRepo.findById(updateProductDto.getCategory()).orElseThrow(()->new ResourceNotFoundException("Category not found"));
        Product product = productRepo.findById(updateProductDto.getId()).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        product.setCategory(category);
        product.setName(updateProductDto.getName());
        product.setUpdatedAt(LocalDate.now());
        product.setPrice(updateProductDto.getPrice());
        product.setQuantity(updateProductDto.getQuantity());
        product.setImage(updateProductDto.getImage());
        product.setDescription(updateProductDto.getDescription());
        product.setDiscount(updateProductDto.getDiscount());
        product.setSpecialPrice(updateProductDto.getSpecialPrice());
        product.setStatus(updateProductDto.isStatus());
        Product save = productRepo.save(product);
        return modelMapper.map(save,ProductResponse.class);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        productRepo.delete(product);
    }

    @Override
    public ProductResponse getProductById(Integer id) {
        Product product = productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        return modelMapper.map(product,ProductResponse.class);
    }

    @Override
    public List<ProductResponse> getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable page = PageRequest.of(pageNumber,pageSize,sort);
        Page<Product> products = productRepo.findAll(page);
        if(products.isEmpty()){
            throw new RuntimeException("Products are not created");
        }
        List<ProductResponse> productResponse = products.stream().map(product -> modelMapper.map(product,ProductResponse.class)).collect(Collectors.toList());
        return productResponse;
    }

    @Override
    public List<ProductResponse> getProductByCategory(Integer categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category not found"));
        Sort sort = sortBy.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable page = PageRequest.of(pageNumber,pageSize,sort);
        Page<Product> products = productRepo.findByCategory(category,page);
        if(products.isEmpty()){
            throw new RuntimeException("Products are not created");
        }

        return products.stream().map(product -> modelMapper.map(product,ProductResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getProductsByName(String keyword, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sort = sortBy.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable page = PageRequest.of(pageNumber,pageSize,sort);
        Page<Product> products = productRepo.findByName(keyword,page);
        if (products.isEmpty())
        {
            throw new RuntimeException("Products are not found with this name");
        }

        return products.stream().map(product -> modelMapper.map(product,ProductResponse.class)).collect(Collectors.toList());
    }


}

