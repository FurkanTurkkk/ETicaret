package com.eCommerce.eCommerce.model.orderitem;

import com.eCommerce.eCommerce.model.product.Product;
import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId",nullable = false)
    private final Product product;

    private final int quantity;


    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
