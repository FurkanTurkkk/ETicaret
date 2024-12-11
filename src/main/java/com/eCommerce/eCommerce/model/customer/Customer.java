package com.eCommerce.eCommerce.model.customer;

import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.order.Order;
import com.eCommerce.eCommerce.model.payment.Payment;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL)
    private final Set<Order> orders=new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId",referencedColumnName = "id")
    private Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private final Set<Payment> payments=new HashSet<>();

    private final String name;
    private final String surName;
    private final String emailAddress;
    private final String phoneNumber;
    private final LocalDate birthDay;
    private final String tckn;

    public Customer() {
        this.tckn = "";
        this.name = "";
        this.surName = "";
        this.emailAddress = "";
        this.phoneNumber = "";
        this.birthDay = null;
    }

    public Customer(String name,
                    String surName,
                    String emailAddress,
                    String phoneNumber,
                    LocalDate birthDay,
                    String tckn) {
        this.name = name;
        this.surName = surName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.tckn = tckn;
    }

    public String getTckn() {
        return tckn;
    }

    public Long getId() {
        return id;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Cart getCarts() {
        return cart;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(tckn, customer.tckn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tckn);
    }

    public static String normalizeName(String name) {
        if (name == null) {
            return null;
        }
        return name.toLowerCase().replaceAll("[\\s,.-]", "");
    }
}
