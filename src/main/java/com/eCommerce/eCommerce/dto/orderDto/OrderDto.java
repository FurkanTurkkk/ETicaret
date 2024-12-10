package com.eCommerce.eCommerce.dto.orderDto;

import com.eCommerce.eCommerce.dto.cartItemDto.CartItemDto;
import com.eCommerce.eCommerce.dto.customerDto.CustomerDto;
import com.eCommerce.eCommerce.dto.orderItemDto.OrderItemDto;

import java.util.Set;

public class OrderDto {
    private Set<OrderItemDto> orderItemDtos;
    private CustomerDto customerDto;

    public OrderDto(Set<OrderItemDto> orderItemDtos, CustomerDto customerDto) {
        this.orderItemDtos = orderItemDtos;
        this.customerDto = customerDto;
    }

    public Set<OrderItemDto> getOrderItemDtos() {
        return orderItemDtos;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }
}
