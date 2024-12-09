package com.eCommerce.eCommerce.model.order;

import com.eCommerce.eCommerce.model.customer.Customer;
import com.eCommerce.eCommerce.model.orderitem.OrderItem;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private final Set<OrderItem> orderItems=new HashSet<>();

    private final LocalDate creationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId",nullable = false)
    private final Customer customer;



    public Order(Customer customer) {
        this.customer = customer;
        this.creationDate = LocalDate.now();
    }
}
