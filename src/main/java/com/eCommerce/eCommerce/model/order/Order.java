package com.eCommerce.eCommerce.model.order;

import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.customer.Customer;
import com.eCommerce.eCommerce.model.orderItem.OrderItem;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId",nullable = false)
    private final Customer customer;

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<OrderItem> orderItems=new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;

    private final double orderNumber;

    private double price;

    private final LocalDate createdDate=LocalDate.now();

    public Order() {
        this.customer=null;
        this.orderNumber=0;
    }

    public Order(Customer customer,Cart cart,Set<OrderItem> orderItems,double price) {
        this.customer = customer;
        this.orderNumber = Math.pow(price,2);
        this.cart=cart;
        this.orderItems=orderItems;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public double getOrderNumber() {
        return orderNumber;
    }

    public Cart getCart() {
        return cart;
    }

}
