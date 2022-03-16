package com.shoppingmall.repository;

import com.shoppingmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JPA Test
 * @ 2022-03-16 손지수
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductName(String productName);

}
