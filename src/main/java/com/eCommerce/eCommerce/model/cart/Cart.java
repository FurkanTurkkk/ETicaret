package com.eCommerce.eCommerce.model.cart;

import com.eCommerce.eCommerce.model.cartItem.CartItem;
import com.eCommerce.eCommerce.model.customer.Customer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart")
    private final Customer customer;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private final Set<CartItem> cartItems=new HashSet<>();

    private double totalPrice;

    private final LocalDate createdDate=LocalDate.now();

    public Cart() {
        this.customer=null;
        this.totalPrice=0;

    }

    public Cart(Customer customer) {
        this.customer = customer;

    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }
}
