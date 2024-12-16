package com.eCommerce.eCommerce.dtoConverter.orderDto;

import com.eCommerce.eCommerce.dto.orderDto.OrderDto;
import com.eCommerce.eCommerce.dto.orderItemDto.OrderItemDto;
import com.eCommerce.eCommerce.dtoConverter.orderItemDto.OrderItemDtoConverter;
import com.eCommerce.eCommerce.model.order.Order;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderDtoConverter {
    private final OrderItemDtoConverter converter;

    public OrderDtoConverter(OrderItemDtoConverter converter) {
        this.converter = converter;
    }

    public OrderDto convert(Order order){
        Set<OrderItemDto> orderItems=order.getOrderItems().stream()
                .map(converter::convert).collect(Collectors.toSet());
        return new OrderDto(
                orderItems,
                order.getCustomer().getId(),
                order.getPrice()
        );
    }
}
