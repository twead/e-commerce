package com.ecommerce.demo.service;

import com.ecommerce.demo.dto.ProductDto;
import com.ecommerce.demo.model.Category;
import com.ecommerce.demo.model.Product;
import com.ecommerce.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductDto createProduct, Category category) {
        Product product = new Product();
        product.setName(createProduct.getName());
        product.setDescription(createProduct.getDescription());
        product.setImageUrl(createProduct.getImageUrl());
        product.setPrice(createProduct.getPrice());
        product.setCategory(category);
        productRepository.save(product);
    }

    public List<Product> allProduct() {
        return productRepository.findAll();
    }
}
