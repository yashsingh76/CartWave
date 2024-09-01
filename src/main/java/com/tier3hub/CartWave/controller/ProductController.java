package com.tier3hub.CartWave.controller;

import com.tier3hub.CartWave.dto.CreateProductDto;
import com.tier3hub.CartWave.dto.ProductResponse;
import com.tier3hub.CartWave.dto.UpdateProductDto;
import com.tier3hub.CartWave.service.ProductService;
import com.tier3hub.CartWave.utils.AppConstants;
import com.tier3hub.CartWave.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/admin/categories/{id}/create")
    public ResponseEntity<Object> createProduct(@RequestBody CreateProductDto createProductDto,@PathVariable Integer id)
    {
        ProductResponse product = productService.addProduct(createProductDto,id);
        return ResponseHandler.generateResponse("Product is added successfully",HttpStatus.CREATED,product);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<Object> updateProduct (@RequestBody UpdateProductDto updateProductDto){
        ProductResponse product = productService.updateProduct(updateProductDto);
        return ResponseHandler.generateResponse("Product is updated successfully",HttpStatus.OK,product);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return ResponseHandler.generateResponse("Product is deleted successfully",HttpStatus.OK,null);
    }

    @GetMapping("/users/getById/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Integer id){
        ProductResponse product = productService.getProductById(id);
        return ResponseHandler.generateResponse("Product is fetched successfully",HttpStatus.FOUND,product);
    }

    @GetMapping("/user/getall")
    public ResponseEntity<Object> getAllProducts(
            @RequestParam (name = "pageNumber" ,defaultValue = AppConstants.pageNumber ,required = false) Integer pageNumber,
            @RequestParam (name = "pageSize" ,defaultValue = AppConstants.pageSize ,required = false) Integer pageSize,
            @RequestParam (name = "sortBy" ,defaultValue = AppConstants.sortBy ,required = false) String sortBy,
            @RequestParam (name = "sortOrder" ,defaultValue = AppConstants.sortOrder ,required = false) String sortOrder
    ){
        List<ProductResponse> product = productService.getAllProducts(pageNumber,pageSize,sortBy,sortOrder);
        return ResponseHandler.generateResponse("Products are fetched successfully",HttpStatus.FOUND,product);
    }

   /* @GetMapping("/users/category/{category_id}/products")
    public ResponseEntity<Object> getProductByCategory(
            @PathVariable Integer category_id,
            @RequestParam (name = "pageNumber" ,defaultValue = AppConstants.pageNumber ,required = false) Integer pageNumber,
            @RequestParam (name = "pageSize" , defaultValue = AppConstants.pageSize ,required = false) Integer pageSize,
            @RequestParam (name = "sortBy" ,defaultValue = AppConstants.sortBy ,required = false) String sortBy,
            @RequestParam (name = "sortOrder" ,defaultValue = AppConstants.sortOrder ,required = false) String sortOrder
    ){
        List<ProductResponse> product = productService.getProductByCategory(category_id,pageNumber,pageSize,sortBy,sortOrder);
        return ResponseHandler.generateResponse("Product are fetched successfully", HttpStatus.FOUND,product);
    }*/



}
