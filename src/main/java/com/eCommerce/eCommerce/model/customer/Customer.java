package com.eCommerce.eCommerce.model.customer;

import com.eCommerce.eCommerce.model.order.Order;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private final Set<Order> orders=new HashSet<>();


    private final String name;
    private final String surName;
    private final String tckn;
    private final LocalDate birthday;
    private final LocalDate enrollDay;



    public Customer(String name, String surName, String tckn, LocalDate birthday) {
        this.name = name;
        this.surName = surName;
        this.tckn = tckn;
        this.birthday = birthday;
        this.enrollDay=LocalDate.now();
    }
}
