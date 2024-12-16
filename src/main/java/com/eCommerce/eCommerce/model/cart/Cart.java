package com.eCommerce.eCommerce.model.cart;

import com.eCommerce.eCommerce.model.cartItem.CartItem;
import com.eCommerce.eCommerce.model.customer.Customer;
import com.eCommerce.eCommerce.model.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart")
    @NotNull
    private Customer customer;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private final Set<CartItem> cartItems = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = true)
    private Order order;

    @Column(nullable = false)
    private double totalPrice;

    private final LocalDate createdDate = LocalDate.now();

    public Cart() {

    }

    public Cart(Customer customer) {
        this.customer = customer;
        this.totalPrice = 0;
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

    public Order getOrder() {
        return order;
    }

    public void upgradeTotalPrice() {
        this.totalPrice = cartItems.stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
    }

    public void removeCartItem(CartItem cartItem) {
        cartItems.remove(cartItem);
        upgradeTotalPrice();
    }

    public void addOrder(Order order){
        this.order=order;
    }

}
