package com.eCommerce.eCommerce.controller;

import com.eCommerce.eCommerce.dto.customerDto.CustomerDto;
import com.eCommerce.eCommerce.request.customerRequest.RequestOfCreateForCustomer;
import com.eCommerce.eCommerce.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createNewCustomer(@RequestBody RequestOfCreateForCustomer request){
        return ResponseEntity.ok(customerService.addCustomer(request));
    }

    @GetMapping("/tckn/{customerTckn}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable("customerTckn") String tckn){
        return ResponseEntity.ok(customerService.findByTc(tckn));
    }

    @DeleteMapping("/delete/tckn/{customerTckn}")
    private ResponseEntity<String> deleteCustomerById(@PathVariable("customerTckn") String tckn){
        return ResponseEntity.ok(customerService.deleteCustomerByTckn(tckn));
    }
}
