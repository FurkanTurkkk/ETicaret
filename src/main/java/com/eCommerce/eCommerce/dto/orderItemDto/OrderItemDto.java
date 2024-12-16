package com.eCommerce.eCommerce.dto.orderItemDto;

import com.eCommerce.eCommerce.dto.productDto.ProductDto;

public class OrderItemDto {
    private ProductDto productDto;
    private int quantity;
    private double price;

    public OrderItemDto(ProductDto productDto, int quantity,double price) {
        this.productDto = productDto;
        this.quantity = quantity;
        this.price=price;
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
