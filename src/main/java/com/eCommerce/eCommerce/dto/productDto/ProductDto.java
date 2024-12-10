package com.eCommerce.eCommerce.dto.productDto;

import com.eCommerce.eCommerce.dto.categoryDto.CategoryDto;

public class ProductDto {

    private String name;
    private double price;
    private int stock;
    private CategoryDto categoryDto;

    public ProductDto(String name, double price, int stock, CategoryDto categoryDto) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.categoryDto = categoryDto;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }
}
