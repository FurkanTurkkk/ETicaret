package com.eCommerce.eCommerce.dtoConverter.cartItemDtoConverter;

import com.eCommerce.eCommerce.dto.cartItemDto.CartItemDto;
import com.eCommerce.eCommerce.dtoConverter.productDtoConverter.ProductDtoConverter;
import com.eCommerce.eCommerce.model.cartItem.CartItem;
import org.springframework.stereotype.Component;

@Component
public class CartItemDtoConverter {
    private final ProductDtoConverter productDtoConverter;

    public CartItemDtoConverter(ProductDtoConverter productDtoConverter) {
        this.productDtoConverter = productDtoConverter;
    }

    public CartItemDto convert(CartItem cartItem){
        return new CartItemDto(
                productDtoConverter.convert(cartItem.getProduct()),
                cartItem.getQuantity()
        );
    }
}
