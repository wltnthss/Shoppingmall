package com.shoppingmall.repository;

import com.shoppingmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JPA Test
 * @ 2022-03-16 손지수
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    // 상품 조회
    List<Product> findByProductName(String productName);

    // 상품명 OR 상품 상세 설명 -> OR 쿼리 메소드
    List<Product> findByProductNameOrDescription(String productName, String description);

    List<Product> findByPriceLessThan(int price);
}
