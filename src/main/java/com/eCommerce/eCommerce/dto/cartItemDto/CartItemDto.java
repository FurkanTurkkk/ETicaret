package com.eCommerce.eCommerce.dto.cartItemDto;

import com.eCommerce.eCommerce.dto.productDto.ProductDto;

public class CartItemDto {
    private ProductDto productDto;
    private int quantity;
    private double price;

    public CartItemDto(ProductDto productDto, int quantity) {
        this.productDto = productDto;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public int getQuantity() {
        return quantity;
    }
}
