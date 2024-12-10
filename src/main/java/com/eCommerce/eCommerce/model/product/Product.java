package com.eCommerce.eCommerce.model.product;

import com.eCommerce.eCommerce.model.category.Category;
import com.eCommerce.eCommerce.model.orderItem.OrderItem;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private final Set<OrderItem> orderItems=new HashSet<>();

    @Column(nullable = false)
    private final String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId",nullable = false)
    private final Category category;

    @Column(nullable = false)
    private final double price;

    private final int stock;

    private String color;

    public Product() {
        this.name = "";
        this.category = null;
        this.price = 0;
        this.stock = 0;
    }

    public Product(String name, Category category, double price, int stock,String color) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.color=color;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getColor() {
        return color;
    }
}
