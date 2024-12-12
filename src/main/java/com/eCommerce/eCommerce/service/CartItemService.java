package com.eCommerce.eCommerce.service;

import com.eCommerce.eCommerce.dto.cartItemDto.CartItemDto;
import com.eCommerce.eCommerce.dtoConverter.cartItemDtoConverter.CartItemDtoConverter;
import com.eCommerce.eCommerce.dtoConverter.productDtoConverter.ProductDtoConverter;
import com.eCommerce.eCommerce.exception.CartItemHasThisProductException;
import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.cartItem.CartItem;
import com.eCommerce.eCommerce.model.customer.Customer;
import com.eCommerce.eCommerce.model.product.Product;
import com.eCommerce.eCommerce.repository.CartItemRepository;
import com.eCommerce.eCommerce.request.cartItemRequest.RequestOfCreateForCartItem;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartItemDtoConverter cartItemDtoConverter;
    private final ProductService productService;
    private final CartService cartService;
    private final CustomerService customerService;

    public CartItemService(CartItemRepository cartItemRepository,
                           CartItemDtoConverter cartItemDtoConverter,
                           ProductService productService,
                           CartService cartService, CustomerService customerService) {
        this.cartItemRepository = cartItemRepository;
        this.cartItemDtoConverter = cartItemDtoConverter;
        this.productService = productService;
        this.cartService = cartService;
        this.customerService = customerService;
    }


    public CartItemDto addCartItem(RequestOfCreateForCartItem request){
        Product product=getProductByProductId(request.productId());
        Cart cart=getCartByCartId(request.cartId());
        CartItem cartItem=findCartItemByProductAndCart(product,cart);
        if(cartItem!=null){
            int upgradeQuantity=cartItem.increaseQuantity(request.quantity());
            cartItem.increasePrice(upgradeQuantity);
            cart.increaseCartPrice(cart);
            cartItemRepository.save(cartItem);
            throw new CartItemHasThisProductException("Product's quantity and price upgrade : "
                    +cartItem.getQuantity()+" price : "+cartItem.getPrice());
        }
        CartItem registerCartItem=new CartItem(
                product,
                cart,
                request.quantity()
        );
        cart.increaseCartPrice(cart);
        cart.getCartItems().add(registerCartItem);
        cartItemRepository.save(registerCartItem);
        return cartItemDtoConverter.convert(registerCartItem);
    }

    public Product getProductByProductId(Long id){
        return productService.findProductByIdOrThrow(id);
    }

    public Cart getCartByCartId(Long id){
        return cartService.getCartByIdOrThrow(id);
    }

    public CartItem findCartItemByProductAndCart(Product product,Cart cart){
        return cartItemRepository.findByProductAndCart(product,cart);
    }

    public void deleteAllCartItem(){
        cartItemRepository.deleteAll();
    }

}
