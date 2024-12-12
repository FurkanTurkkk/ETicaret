package com.eCommerce.eCommerce.model.cartItem;

import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.product.Product;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId",nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cartId",nullable = false)
    private Cart cart;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    public CartItem() {

    }

    public CartItem(Product product, Cart cart, int quantity) {
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
        this.price=quantity*product.getPrice();
    }

    public double getPrice() {
        return price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(product, cartItem.product) && Objects.equals(cart, cartItem.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, cart);
    }

    public int increaseQuantity(int quantity){
        this.quantity+=quantity;
        return this.quantity;
    }

    public void decreaseQuantity(int quantity){
        this.quantity-=quantity;
    }

    public void increasePrice(int quantity){
        this.price=quantity*product.getPrice();
    }

}
