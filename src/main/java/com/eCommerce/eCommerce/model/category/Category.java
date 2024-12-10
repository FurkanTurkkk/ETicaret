package com.eCommerce.eCommerce.model.category;

import com.eCommerce.eCommerce.model.product.Product;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "category")
    private Set<Product> products=new HashSet<>();

    private final String name;

    public Category() {
        this.name="";
    }

    public Category(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }
}
