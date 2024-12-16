package com.eCommerce.eCommerce.model.orderItem;

import com.eCommerce.eCommerce.model.order.Order;
import com.eCommerce.eCommerce.model.product.Product;
import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId",nullable = false)
    private final Product product;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private final Order order;

    private final int quantity;

    private double price;

    public OrderItem() {
        this.product = null;
        this.order = null;
        this.quantity = 0;
    }

    public OrderItem(Product product, Order order, int quantity,double price) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }

    public int getQuantity() {
        return quantity;
    }
}
