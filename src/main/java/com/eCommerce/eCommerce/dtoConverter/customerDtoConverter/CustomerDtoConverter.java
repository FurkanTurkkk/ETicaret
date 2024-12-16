package com.eCommerce.eCommerce.dtoConverter.customerDtoConverter;

import com.eCommerce.eCommerce.dto.customerDto.CustomerDto;
import com.eCommerce.eCommerce.dto.orderDto.OrderDto;
import com.eCommerce.eCommerce.dtoConverter.orderDto.OrderDtoConverter;
import com.eCommerce.eCommerce.model.customer.Customer;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {
    private final OrderDtoConverter orderDtoConverter;

    public CustomerDtoConverter(OrderDtoConverter orderDtoConverter) {
        this.orderDtoConverter = orderDtoConverter;
    }

    public CustomerDto convertToCustomerDto(Customer customer){
        Set<OrderDto> orderDtos=customer.getOrders().stream()
                .map(orderDtoConverter::convert).collect(Collectors.toSet());;
        return new CustomerDto(
                customer.getName(),
                customer.getSurName(),
                customer.getEmailAddress(),
                customer.getPhoneNumber(),
                customer.getBirthDay(),
                customer.getTckn(),
                orderDtos
        );
    }
}
