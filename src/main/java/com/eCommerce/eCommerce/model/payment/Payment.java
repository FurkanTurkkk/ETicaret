package com.eCommerce.eCommerce.model.payment;

import com.eCommerce.eCommerce.model.customer.Customer;
import com.eCommerce.eCommerce.model.order.Order;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;

    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private Customer customer;

    private final LocalDate paymentDate=LocalDate.now();
    private Statu statu;
    private double amount;

    public Payment() {
    }

    public Payment(Order order, Statu statu, double amount) {
        this.order = order;
        this.statu = statu;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public Statu getStatu() {
        return statu;
    }

    public double getAmount() {
        return amount;
    }
}
