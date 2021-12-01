package com.ecommerce.demo.controller;

import com.ecommerce.demo.model.Category;
import com.ecommerce.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "success";
    }

    @GetMapping("/list")
    public List<Category> allCategories(){
        return categoryService.allCategories();
    }

    @PutMapping("/update/{categoryId}")
    public String editCategory(@RequestParam("categoryId") Integer id, @RequestBody Category category ){
        categoryService.editCategory(id, category);
        return "testing";
    }
}
