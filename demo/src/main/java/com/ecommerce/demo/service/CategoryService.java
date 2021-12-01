package com.ecommerce.demo.service;

import com.ecommerce.demo.dto.CategoryDto;
import com.ecommerce.demo.model.Category;
import com.ecommerce.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void createCategory(CategoryDto createCategory){
        Category category = new Category();
        category.setCategoryName(createCategory.getCategoryName());
        category.setDescription(createCategory.getDescription());
        category.setImageUrl(createCategory.getImageUrl());
        categoryRepository.save(category);
    }

    public List<Category> allCategories(){
        return categoryRepository.findAll();
    }

    public void editCategory(Integer id, CategoryDto updateCategory) {
        Category category = categoryRepository.getById(id);
        category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
        category.setImageUrl(updateCategory.getImageUrl());
        categoryRepository.save(category);
    }

    public boolean existsById(Integer id) {
        return categoryRepository.findById(id).isPresent();
    }

    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }
}
