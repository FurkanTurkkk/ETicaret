package com.eCommerce.eCommerce.model.orderItem;

import com.eCommerce.eCommerce.model.product.Product;
import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private final Product product;

    public OrderItem() {
        this.product=null;
    }

    public OrderItem(Product product) {
        this.product = product;
    }
}
