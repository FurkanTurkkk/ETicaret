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

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private final Set<Product> products=new HashSet<>();

    private final String name;


    public Category(String name) {
        this.name = name;
    }
}
