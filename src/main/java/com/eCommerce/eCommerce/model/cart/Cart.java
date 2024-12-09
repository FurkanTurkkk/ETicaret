package com.eCommerce.eCommerce.model.cart;

import com.eCommerce.eCommerce.model.cartitem.CartItem;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private final Set<CartItem> cartItems=new HashSet<>();

}
