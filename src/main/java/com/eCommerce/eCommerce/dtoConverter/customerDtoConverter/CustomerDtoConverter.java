package com.eCommerce.eCommerce.dtoConverter.customerDtoConverter;

import com.eCommerce.eCommerce.dto.customerDto.CustomerDto;
import com.eCommerce.eCommerce.model.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {
    public CustomerDto convertToCustomerDto(Customer customer){
        return new CustomerDto(
                customer.getName(),
                customer.getSurName(),
                customer.getEmailAddress(),
                customer.getPhoneNumber(),
                customer.getBirthDay(),
                customer.getTckn()
        );
    }
}
