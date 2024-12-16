package com.eCommerce.eCommerce.service;

import com.eCommerce.eCommerce.dto.orderDto.OrderDto;
import com.eCommerce.eCommerce.dtoConverter.orderDto.OrderDtoConverter;
import com.eCommerce.eCommerce.factory.OrderFactory;
import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.cartItem.CartItem;
import com.eCommerce.eCommerce.model.order.Order;
import com.eCommerce.eCommerce.model.orderItem.OrderItem;
import com.eCommerce.eCommerce.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final OrderDtoConverter converter;

    public OrderService(OrderRepository orderRepository, CartService cartService, OrderDtoConverter converter) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.converter = converter;
    }

    private Order addOrder(Cart cart){
        Order order= OrderFactory.createOrderFromCart(cart);
        orderRepository.save(order);
        deleteCart(cart);
        return order;
    }

    public OrderDto createOrder(Long id){
        Cart cart=cartService.getCartByIdOrThrow(id);
        Order order=addOrder(cart);
        return converter.convert(order);
    }

    private void deleteCart(Cart cart){
        cartService.deleteCart(cart.getCustomer().getTckn());
    }
}
