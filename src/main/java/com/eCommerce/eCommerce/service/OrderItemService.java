package com.eCommerce.eCommerce.service;

import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.cartItem.CartItem;
import com.eCommerce.eCommerce.model.order.Order;
import com.eCommerce.eCommerce.model.orderItem.OrderItem;
import com.eCommerce.eCommerce.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }


}
