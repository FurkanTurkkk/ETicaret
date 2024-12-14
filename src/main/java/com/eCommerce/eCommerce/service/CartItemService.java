package com.eCommerce.eCommerce.service;

import com.eCommerce.eCommerce.dto.cartItemDto.CartItemDto;
import com.eCommerce.eCommerce.dtoConverter.cartItemDtoConverter.CartItemDtoConverter;
import com.eCommerce.eCommerce.exception.CartItemHasThisProductException;
import com.eCommerce.eCommerce.exception.CartItemNotFoundException;
import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.cartItem.CartItem;
import com.eCommerce.eCommerce.model.product.Product;
import com.eCommerce.eCommerce.repository.CartItemRepository;
import com.eCommerce.eCommerce.request.cartItemRequest.RequestOfCreateForCartItem;
import com.eCommerce.eCommerce.service.implementation.Helper;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartItemDtoConverter cartItemDtoConverter;
    private final Helper helper;
    private final CartService cartService;

    public CartItemService(CartItemRepository cartItemRepository,
                           CartItemDtoConverter cartItemDtoConverter,
                           Helper helper,
                           CartService cartService) {
        this.cartItemRepository = cartItemRepository;
        this.cartItemDtoConverter = cartItemDtoConverter;
        this.helper = helper;
        this.cartService = cartService;
    }

    public CartItem findCartItemByIdOrThrow(Long id){
        return cartItemRepository.findById(id)
                .orElseThrow(()->new CartItemNotFoundException("Cart item not found by id : "+id));
    }


    public CartItemDto addCartItem(RequestOfCreateForCartItem request){
        Product product=getProductByProductId(request.productId());
        Cart cart=getCartByCartId(request.cartId());
        CartItem cartItem=findCartItemByProductAndCart(product,cart);
        if(cartItem!=null){
            int upgradeQuantity=cartItem.increaseQuantity(request.quantity());
            cartItem.upgradePrice(upgradeQuantity);
            cart.upgradeTotalPrice();
            cartItemRepository.save(cartItem);
            throw new CartItemHasThisProductException("Product's quantity and price upgrade : "
                    +cartItem.getQuantity()+" price : "+cartItem.getPrice());
        }
        CartItem registerCartItem=new CartItem(
                product,
                cart,
                request.quantity()
        );

        cart.getCartItems().add(registerCartItem);
        cart.upgradeTotalPrice();
        cartItemRepository.save(registerCartItem);
        return cartItemDtoConverter.convert(registerCartItem);
    }

    public Product getProductByProductId(Long id){
        return helper.getProductService().findProductByIdOrThrow(id);
    }

    public Cart getCartByCartId(Long id){
        return cartService.getCartByIdOrThrow(id);
    }

    public CartItemDto getCartItemDtoById(Long id){
        CartItem cartItem=findCartItemByIdOrThrow(id);
        return cartItemDtoConverter.convert(cartItem);
    }

    public CartItem findCartItemByProductAndCart(Product product,Cart cart){
        return cartItemRepository.findByProductAndCart(product,cart);
    }

    public void deleteCartItemByCartItemId(Long id){
        CartItem cartItem=findCartItemByIdOrThrow(id);
        Cart cart=cartItem.getCart();
        cart.getCartItems().remove(cartItem);
        cart.upgradeTotalPrice();
        cartService.saveNewCart(cart);
        cartItemRepository.deleteById(id);
    }


}
