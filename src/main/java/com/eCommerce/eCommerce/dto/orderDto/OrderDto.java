package com.eCommerce.eCommerce.dto.orderDto;

import com.eCommerce.eCommerce.dto.cartItemDto.CartItemDto;
import com.eCommerce.eCommerce.dto.customerDto.CustomerDto;
import com.eCommerce.eCommerce.dto.orderItemDto.OrderItemDto;

import java.time.LocalDate;
import java.util.Set;

public class OrderDto {
    private Set<OrderItemDto> orderItemDtos;
    private Long customerId;
    private double price;
    private LocalDate createdDate=LocalDate.now();

    public OrderDto(Set<OrderItemDto> orderItemDtos, Long customerId,double price) {
        this.orderItemDtos = orderItemDtos;
        this.customerId=customerId;
        this.price=price;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public double getPrice() {
        return price;
    }

    public Set<OrderItemDto> getOrderItemDtos() {
        return orderItemDtos;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
