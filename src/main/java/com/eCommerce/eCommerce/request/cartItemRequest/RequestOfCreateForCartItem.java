package com.eCommerce.eCommerce.request.cartItemRequest;

public record RequestOfCreateForCartItem(
        Long productId,
        int quantity,
        Long cartId
) {

}
