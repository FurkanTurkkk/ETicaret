package com.eCommerce.eCommerce.dto.cartDto;

import com.eCommerce.eCommerce.dto.cartItemDto.CartItemDto;
import com.eCommerce.eCommerce.dto.customerDto.CustomerDto;

import java.util.Set;

public class CartDto {
    private Set<CartItemDto> cartItemDtos;
    private CustomerDto customerDto;

    public CartDto(Set<CartItemDto> cartItemDtos, CustomerDto customerDto) {
        this.cartItemDtos = cartItemDtos;
        this.customerDto = customerDto;
    }

    public Set<CartItemDto> getCartItemDtos() {
        return cartItemDtos;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }
}
