package com.eCommerce.eCommerce.service;

import com.eCommerce.eCommerce.dto.cartDto.CartDto;
import com.eCommerce.eCommerce.dtoConverter.cartDtoConverter.CartDtoConverter;
import com.eCommerce.eCommerce.exception.CartAlreadyExistOfCustomerException;
import com.eCommerce.eCommerce.exception.CartNotFoundException;
import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.cartItem.CartItem;
import com.eCommerce.eCommerce.model.customer.Customer;
import com.eCommerce.eCommerce.repository.CartRepository;
import com.eCommerce.eCommerce.request.cartRequest.RequestOfCreateForCart;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartDtoConverter cartDtoConverter;
    private final CustomerService customerService;

    public CartService(CartRepository cartRepository, CartDtoConverter cartDtoConverter, CustomerService customerService) {
        this.cartRepository = cartRepository;
        this.cartDtoConverter = cartDtoConverter;
        this.customerService = customerService;
    }

    public Cart getCartByIdOrThrow(Long id){
        return cartRepository.findById(id)
                .orElseThrow(()->new CartNotFoundException("Cart can not found by id : "+id));
    }


    public CartDto getCartByCustomerTckn(String tc){
        Customer customer=customerService.findByTcOrThrow(tc);
        Cart cart=cartRepository.findByCustomer(customer)
                .orElseThrow(()->new CartNotFoundException("Cart can not found"));
        return cartDtoConverter.convert(cart);
    }

    public CartDto createCart(RequestOfCreateForCart request){
        Customer customer=customerService.findByTcOrThrow(request.customerTckn());
        Cart cart=new Cart(customer);
        if(customer.getCart()!=null){
            throw new CartAlreadyExistOfCustomerException("Customer has already cart");
        }
        customer.addCart(cart);
        cartRepository.save(cart);
        return cartDtoConverter.convert(cart);
    }

    public void deleteCart(String tc){
        Customer customer=customerService.findByTcOrThrow(tc);
        Cart cart=customer.getCart();
        customer.deleteCart();
        cartRepository.delete(cart);
    }

}
