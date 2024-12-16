package com.eCommerce.eCommerce.factory;

import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.cartItem.CartItem;
import com.eCommerce.eCommerce.model.order.Order;
import com.eCommerce.eCommerce.model.orderItem.OrderItem;

import java.util.Set;
import java.util.stream.Collectors;

public class OrderFactory {
    public static Order createOrderFromCart(Cart cart){

        Set<OrderItem> orderItems = cart.getCartItems().stream()
                .map(OrderFactory::createOrderItemFromCartItem)
                .collect(Collectors.toSet());

        double totalPrice = cart.getTotalPrice();

        Order order = new Order(
                cart.getCustomer(),
                cart,
                orderItems,
                totalPrice
        );

        cart.addOrder(order);

        return order;
    }
    private static OrderItem createOrderItemFromCartItem(CartItem cartItem){
        return new OrderItem(
                cartItem.getProduct(),
                cartItem.getCart().getOrder(),
                cartItem.getQuantity(),
                cartItem.getPrice()
        );
    }


}
