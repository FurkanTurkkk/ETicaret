package com.eCommerce.eCommerce.model.cartitem;

import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.product.Product;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private final Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cartId")
    private final Cart cart;

    private final int quantity;


    public CartItem(Product product, Cart cart, int quantity) {
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
    }
}
