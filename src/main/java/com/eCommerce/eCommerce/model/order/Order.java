package com.eCommerce.eCommerce.model.order;

import com.eCommerce.eCommerce.model.customer.Customer;
import com.eCommerce.eCommerce.model.orderItem.OrderItem;
import com.eCommerce.eCommerce.model.payment.Payment;
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
    private final Set<OrderItem> orderItems=new HashSet<>();

    private final double orderNumber;

    private double price;

    private final LocalDate createdDate=LocalDate.now();

    @OneToOne(mappedBy = "order")
    private final Payment payment;

    public Order() {
        this.customer=null;
        this.orderNumber=0;
        this.payment=null;
    }

    public Order(Customer customer, Long orderNumber,Payment payment) {
        this.customer = customer;
        this.orderNumber = Math.random()*1000;
        this.payment=payment;

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
}
