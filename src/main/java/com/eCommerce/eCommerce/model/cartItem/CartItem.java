package com.eCommerce.eCommerce.model.cartItem;

import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.product.Product;
import jakarta.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId",nullable = false)
    private final Product product;

    @ManyToOne
    @JoinColumn(name = "cartId",nullable = false)
    private final Cart cart;

    private final int quantity;

    public CartItem() {
        this.product = null;
        this.cart = null;
        this.quantity = 0;
    }

    public CartItem(Product product, Cart cart, int quantity) {
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Cart getCart() {
        return cart;
    }

    public int getQuantity() {
        return quantity;
    }
}
