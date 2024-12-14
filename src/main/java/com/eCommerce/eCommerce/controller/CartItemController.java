package com.eCommerce.eCommerce.controller;


import com.eCommerce.eCommerce.dto.cartItemDto.CartItemDto;
import com.eCommerce.eCommerce.request.cartItemRequest.RequestOfCreateForCartItem;
import com.eCommerce.eCommerce.service.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cartItem")
public class CartItemController {
    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping
    public ResponseEntity<CartItemDto> addCartItem(@RequestBody RequestOfCreateForCartItem request){
        return ResponseEntity.ok(cartItemService.addCartItem(request));
    }

    @GetMapping("/find/{cartItemId}")
    public ResponseEntity<CartItemDto> findCartItemById(@PathVariable("cartItemId")Long id){
        return ResponseEntity.ok(cartItemService.getCartItemDtoById(id));
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<String> deleteCartItemById(@PathVariable("cartItemId")Long id){
        cartItemService.deleteCartItemByCartItemId(id);
        return ResponseEntity.ok("Cart Item deleted successfully by id : "+id);
    }

}
