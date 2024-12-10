package com.eCommerce.eCommerce.model.cart;

import com.eCommerce.eCommerce.model.cartItem.CartItem;
import com.eCommerce.eCommerce.model.customer.Customer;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private final Customer customer;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private final Set<CartItem> cartItems=new HashSet<>();

    public Cart() {
        this.customer=null;
    }

    public Cart(Customer customer) {
        this.customer = customer;
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
