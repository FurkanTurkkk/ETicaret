package com.eCommerce.eCommerce.dtoConverter.cartDtoConverter;

import com.eCommerce.eCommerce.dto.cartDto.CartDto;
import com.eCommerce.eCommerce.dtoConverter.cartItemDtoConverter.CartItemDtoConverter;
import com.eCommerce.eCommerce.dtoConverter.customerDtoConverter.CustomerDtoConverter;
import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.cartItem.CartItem;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CartDtoConverter {
    private final CartItemDtoConverter cartItemDtoConverter;
    private final CustomerDtoConverter customerDtoConverter;
    public CartDtoConverter(CartItemDtoConverter converter, CustomerDtoConverter customerDtoConverter) {
        this.cartItemDtoConverter = converter;
        this.customerDtoConverter = customerDtoConverter;
    }

    public CartDto convert(Cart cart){
        Set<CartItem> cartItems=cart.getCartItems();
        return new CartDto(
                cartItems.stream()
                        .map(cartItemDtoConverter::convert)
                        .collect(Collectors.toSet()),
                customerDtoConverter.convertToCustomerDto(cart.getCustomer())
        );
    }
}
