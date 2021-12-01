package com.ecommerce.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Integer id;
    private @NotBlank String name;
    private @NotBlank String imageUrl;
    private @NotBlank double price;
    private @NotBlank String description;
    private @NotBlank Integer categoryId;

}
