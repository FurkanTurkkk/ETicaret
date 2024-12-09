package com.eCommerce.eCommerce.dto.cartItemDto;

import com.eCommerce.eCommerce.dto.productDto.ProductDto;

public class CartItemDto {
    private ProductDto productDto;
    private int quantity;

    public CartItemDto(ProductDto productDto, int quantity) {
        this.productDto = productDto;
        this.quantity = quantity;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public int getQuantity() {
        return quantity;
    }
}
