package com.eCommerce.eCommerce.model.product;

import com.eCommerce.eCommerce.model.cartitem.CartItem;
import com.eCommerce.eCommerce.model.category.Category;
import com.eCommerce.eCommerce.model.orderitem.OrderItem;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId",nullable = false)
    private final Category category;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private final Set<CartItem> cartItems=new HashSet<>();

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private final Set<OrderItem> orderItems=new HashSet<>();


    private final String name;
    private final Long stock;
    private final Double price;
    private final String code;



    public Product(Category category, String name, Long stock, Double price) {
        this.category = category;
        this.name = name;
        this.stock = stock;
        this.price = price;
        code = UUID.randomUUID().toString().replace("-","").substring(0-12);
    }


}
