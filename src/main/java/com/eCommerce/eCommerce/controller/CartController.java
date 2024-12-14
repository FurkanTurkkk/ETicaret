package com.eCommerce.eCommerce.controller;

import com.eCommerce.eCommerce.dto.cartDto.CartDto;
import com.eCommerce.eCommerce.request.cartRequest.RequestOfCreateForCart;
import com.eCommerce.eCommerce.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<CartDto> createCart(@RequestBody RequestOfCreateForCart request){
        return ResponseEntity.ok(cartService.createCart(request));
    }

    @GetMapping("/find/cartItems/{customerTckn}")
    public ResponseEntity<CartDto> getCart(@PathVariable("customerTckn")String tc){
        return ResponseEntity.ok(cartService.getCartByCustomerTckn(tc));
    }

    @DeleteMapping("/delete/{customerTckn}")
    public ResponseEntity<String> deleteCart(@PathVariable("customerTckn") String tc){
        cartService.deleteCart(tc);
        return ResponseEntity.ok("Deleted Cart Successfully");
    }
}
