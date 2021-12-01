package com.ecommerce.demo.service;

import com.ecommerce.demo.model.Category;
import com.ecommerce.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

}
