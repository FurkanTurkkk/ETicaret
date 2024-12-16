package com.eCommerce.eCommerce.dtoConverter.orderItemDto;

import com.eCommerce.eCommerce.dto.orderItemDto.OrderItemDto;
import com.eCommerce.eCommerce.dtoConverter.productDtoConverter.ProductDtoConverter;
import com.eCommerce.eCommerce.model.orderItem.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemDtoConverter {
    private final ProductDtoConverter converter;

    public OrderItemDtoConverter(ProductDtoConverter converter) {
        this.converter = converter;
    }

    public OrderItemDto convert(OrderItem orderItem){
        return new OrderItemDto(
                converter.convert(orderItem.getProduct()),
                orderItem.getQuantity(),
                orderItem.getPrice()
        );
    }
}
