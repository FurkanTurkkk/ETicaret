package com.eCommerce.eCommerce.repository;

import com.eCommerce.eCommerce.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByName(String name);
    Optional<Product> findByNameAndColor(String name,String color);
}
