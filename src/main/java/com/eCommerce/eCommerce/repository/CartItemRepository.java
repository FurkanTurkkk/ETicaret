package com.eCommerce.eCommerce.repository;

import com.eCommerce.eCommerce.model.cart.Cart;
import com.eCommerce.eCommerce.model.cartItem.CartItem;
import com.eCommerce.eCommerce.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    CartItem findByProductAndCart(Product product, Cart cart);
}
