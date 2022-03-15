package com.shoppingmall.repository;

import com.shoppingmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Test
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
