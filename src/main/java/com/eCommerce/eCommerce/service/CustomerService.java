package com.eCommerce.eCommerce.service;

import com.eCommerce.eCommerce.dto.customerDto.CustomerDto;
import com.eCommerce.eCommerce.dtoConverter.customerDtoConverter.CustomerDtoConverter;
import com.eCommerce.eCommerce.exception.CustomerExistException;
import com.eCommerce.eCommerce.exception.CustomerNotFoundException;
import com.eCommerce.eCommerce.model.customer.Customer;
import com.eCommerce.eCommerce.repository.CustomerRepository;
import com.eCommerce.eCommerce.request.customerRequest.RequestOfCreateForCustomer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    public Customer findByTcOrThrow(String tc){
        return customerRepository.findByTckn(tc)
                .orElseThrow(()->new CustomerNotFoundException("Customer not found by tc "+tc));
    }

    public CustomerDto addCustomer(RequestOfCreateForCustomer request){
        if(customerRepository.findByTckn(request.tckn()).isPresent()){
            throw new CustomerExistException("Customer already exist by TCKN "+request.tckn());
        }
        Customer customer=new Customer(
                request.name(),
                request.surName(),
                request.emailAddress(),
                request.phoneNumber(),
                request.birthDay(),
                request.tckn()
        );
        customerRepository.save(customer);
        return customerDtoConverter.convertToCustomerDto(customer);
    }

    public CustomerDto findByTc(String tc){
        Customer customer=findByTcOrThrow(tc);
        return customerDtoConverter.convertToCustomerDto(customer);
    }

    public String deleteCustomerByTckn(String tckn){
        Customer customer=findByTcOrThrow(tckn);
        customerRepository.delete(customer);
        return "Deleted Customer Successfully";
    }
}
