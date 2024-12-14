package com.eCommerce.eCommerce.service.implementation;

import com.eCommerce.eCommerce.service.CartItemService;
import com.eCommerce.eCommerce.service.ProductService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Helper {
    private final ProductService productService;
    private final CartItemService cartItemService;

    public Helper(@Lazy ProductService productService, @Lazy CartItemService cartItemService) {
        this.productService = productService;
        this.cartItemService = cartItemService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public CartItemService getCartItemService() {
        return cartItemService;
    }
}
