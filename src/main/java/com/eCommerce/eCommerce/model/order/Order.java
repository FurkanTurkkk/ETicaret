package com.eCommerce.eCommerce.model.order;

import com.eCommerce.eCommerce.model.customer.Customer;
import com.eCommerce.eCommerce.model.orderItem.OrderItem;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId",nullable = false)
    private final Customer customer;

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final Set<OrderItem> orderItems=new HashSet<>();

    private final double orderNumber;

    public Order() {
        this.customer=null;
        this.orderNumber=0;
    }

    public Order(Customer customer, Long orderNumber) {
        this.customer = customer;
        this.orderNumber = Math.random()*1000;
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
}
