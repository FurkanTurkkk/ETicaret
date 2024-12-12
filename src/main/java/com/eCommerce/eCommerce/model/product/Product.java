package com.eCommerce.eCommerce.model.product;

import com.eCommerce.eCommerce.model.cartItem.CartItem;
import com.eCommerce.eCommerce.model.category.Category;
import com.eCommerce.eCommerce.model.orderItem.OrderItem;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<OrderItem> orderItems=new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<CartItem> cartItems=new HashSet<>();

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId",nullable = false)
    private Category category;

    @Column(nullable = false)
    private double price;

    private int stock;

    private String color;

    public Product() {

    }

    public Product(String name, Category category, double price, int stock,String color) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.color=color;
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(category, product.category) && Objects.equals(color, product.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, color);
    }

    public void increaseStock(int quantity){
        this.stock+=quantity;
    }
    public void decreaseStock(int quantity){
        this.stock-=quantity;
    }


}
