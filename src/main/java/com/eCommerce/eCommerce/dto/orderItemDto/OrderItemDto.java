package com.eCommerce.eCommerce.dto.orderItemDto;

import com.eCommerce.eCommerce.dto.productDto.ProductDto;

public class OrderItemDto {
    private ProductDto productDto;
    private int quantity;
    private double price;

    public OrderItemDto(ProductDto productDto, int quantity) {
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
