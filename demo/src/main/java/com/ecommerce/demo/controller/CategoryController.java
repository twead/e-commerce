package com.ecommerce.demo.controller;

import com.ecommerce.demo.common.ApiResponse;
import com.ecommerce.demo.model.Category;
import com.ecommerce.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true,"category created"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Category> allCategories(){
        return categoryService.allCategories();
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> editCategory(@RequestParam("categoryId") Integer id, @RequestBody Category category ){
        if(!categoryService.existsById(id)){
            return new ResponseEntity<>(new ApiResponse(false,"category not found"), HttpStatus.NOT_FOUND);
        }
        categoryService.editCategory(id, category);
        return new ResponseEntity<>(new ApiResponse(true,"category updated"), HttpStatus.OK);
    }
}
