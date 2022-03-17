package com.shoppingmall.repository;

import com.shoppingmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    // 상품 가격보다 적을 때 -> LessThan
    List<Product> findByPriceLessThan(int price);

    // 복잡한 쿼리를 위한 JPQL
    @Query("select i from Product i where i.description like %:description order by i.price desc")
    List<Product> findByDescription(@Param("description") String description);
}
