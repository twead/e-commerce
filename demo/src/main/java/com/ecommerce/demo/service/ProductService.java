package com.ecommerce.demo.service;

import com.ecommerce.demo.dto.ProductDto;
import com.ecommerce.demo.exception.EcommerceCustomException;
import com.ecommerce.demo.model.Category;
import com.ecommerce.demo.model.Product;
import com.ecommerce.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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

    public List<ProductDto> allProduct() {
        List<Product> allProducts = productRepository.findAll();
        List<ProductDto> productDtos = new LinkedList<>();
        for(Product product : allProducts){
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }

    public ProductDto getProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());
        return productDto;
    }

    public void editProduct(Integer id, ProductDto productDto, Category category) throws EcommerceCustomException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new EcommerceCustomException("product not exists");
        }
        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        productRepository.save(product);
    }

}
