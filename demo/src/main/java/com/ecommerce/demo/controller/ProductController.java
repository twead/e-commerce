package com.ecommerce.demo.controller;

import com.ecommerce.demo.common.ApiResponse;
import com.ecommerce.demo.dto.ProductDto;
import com.ecommerce.demo.model.Category;
import com.ecommerce.demo.service.CategoryService;
import com.ecommerce.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto product){
        Optional<Category> category = categoryService.findById(product.getCategoryId());
        if(category.isEmpty()){
            return new ResponseEntity<>(new ApiResponse(false,"category does not exists"), HttpStatus.BAD_REQUEST);
        }
        productService.createProduct(product, category.get());
        return new ResponseEntity<>(new ApiResponse(true,"product has been added"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> allProducts(){
        return new ResponseEntity<>(productService.allProduct(),HttpStatus.OK);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> editProduct(@PathVariable("productId") Integer id, @RequestBody ProductDto product){
        Optional<Category> category = categoryService.findById(product.getCategoryId());
        if(category.isEmpty()){
            return new ResponseEntity<>(new ApiResponse(false,"category does not exists"), HttpStatus.BAD_REQUEST);
        }
        productService.editProduct(product, id);
        return new ResponseEntity<>(new ApiResponse(true,"product has been added"), HttpStatus.CREATED);
    }

}
