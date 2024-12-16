package com.eCommerce.eCommerce.controller;

import com.eCommerce.eCommerce.dto.orderDto.OrderDto;
import com.eCommerce.eCommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{cartId}")
    public ResponseEntity<OrderDto> createOrder(@PathVariable("cartId")Long id){
        return ResponseEntity.ok(orderService.createOrder(id));
    }
}
