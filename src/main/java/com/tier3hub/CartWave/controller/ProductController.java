package com.tier3hub.CartWave.controller;

import com.tier3hub.CartWave.dto.CreateProductDto;
import com.tier3hub.CartWave.dto.ProductResponse;
import com.tier3hub.CartWave.dto.UpdateProductDto;
import com.tier3hub.CartWave.service.ProductService;
import com.tier3hub.CartWave.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/admin/create")
    public ResponseEntity<Object> createProduct(@RequestBody CreateProductDto createProductDto) {
        ProductResponse product = productService.createProduct(createProductDto);
        return ResponseHandler.generateResponse("Product created successfully", HttpStatus.CREATED, product);
    }

    @PutMapping("admin/category/{categoryId}/product/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody UpdateProductDto updateProductDto) {
        ProductResponse product = productService.updateProduct(updateProductDto);
        return ResponseHandler.generateResponse("Product updated successfully", HttpStatus.OK, product);
    }

    @GetMapping("/users/getProduct/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Integer id) {
        ProductResponse product = productService.getProduct(id);
        return ResponseHandler.generateResponse("Product fetched successfully", HttpStatus.OK, product);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseHandler.generateResponse("Product deleted successfully", HttpStatus.OK, null);
    }


}
