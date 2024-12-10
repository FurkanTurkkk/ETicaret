package com.eCommerce.eCommerce.dto.categoryDto;

import com.eCommerce.eCommerce.dto.productDto.ProductDto;

import java.util.HashSet;
import java.util.Set;

public class WithProductsCategoryDto {
    private final String name;
    private Set<ProductDto> productDtos=new HashSet<>();

    public WithProductsCategoryDto(String name, Set<ProductDto> productDtos) {
        this.name = name;
        this.productDtos = productDtos;
    }

    public String getName() {
        return name;
    }

    public Set<ProductDto> getProductDtos() {
        return productDtos;
    }
}
