package com.ecommerce.demo.service;

import com.ecommerce.demo.model.Category;
import com.ecommerce.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public List<Category> allCategories(){
        return categoryRepository.findAll();
    }

    public void editCategory(Integer id, Category category) {
        Category oldCategory = categoryRepository.getById(id);
        oldCategory.setCategoryName(category.getCategoryName());
        oldCategory.setDescription(category.getDescription());
        oldCategory.setImageUrl(category.getImageUrl());
        categoryRepository.save(oldCategory);
    }

    public boolean existsById(Integer id) {
        return categoryRepository.findById(id).isPresent();
    }
}
