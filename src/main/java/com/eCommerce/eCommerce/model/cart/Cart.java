package com.eCommerce.eCommerce.model.cart;

import com.eCommerce.eCommerce.model.cartItem.CartItem;
import com.eCommerce.eCommerce.model.customer.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart")
    @NotNull
    private Customer customer;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private final Set<CartItem> cartItems=new HashSet<>();

    @Column(nullable = false)
    private double totalPrice;

    private final LocalDate createdDate=LocalDate.now();

    public Cart() {

    }

    public Cart(Customer customer) {
        this.customer = customer;
        this.totalPrice=0;
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

    public void increaseCartPrice(Cart cart){
       List<Double> prices=cart.getCartItems().stream()
               .map(CartItem::getPrice).toList();
       for (Double price : prices){
           this.totalPrice=price;
       }
    }

}
