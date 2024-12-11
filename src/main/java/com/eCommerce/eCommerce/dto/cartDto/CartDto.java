package com.eCommerce.eCommerce.dto.cartDto;

import com.eCommerce.eCommerce.dto.cartItemDto.CartItemDto;
import com.eCommerce.eCommerce.dto.customerDto.CustomerDto;

import java.time.LocalDate;
import java.util.Set;

public class CartDto {
    private Set<CartItemDto> cartItemDtos;
    private CustomerDto customerDto;
    private double totalPrice;
    private LocalDate createdDate=LocalDate.now();

    public CartDto(Set<CartItemDto> cartItemDtos, CustomerDto customerDto) {
        this.cartItemDtos = cartItemDtos;
        this.customerDto = customerDto;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Set<CartItemDto> getCartItemDtos() {
        return cartItemDtos;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }
}
