package com.shoppingmall.repository;

import com.shoppingmall.constant.ProductSellStatus;
import com.shoppingmall.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ProductRepository Test
 */
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")    //application.properties 보다 높은 우선순위이기 때문에 사용함
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createProductTest(){
        Product product = new Product();
        product.setP_name("테스트 상품");
        product.setPrice(1000);
        product.setDescription("테스트 상품 설명");
        product.setProduct_sell_status(ProductSellStatus.SELL);
        product.setStock_number(100);
        product.setCreated_date(LocalDateTime.now());
        product.setModified_date(LocalDateTime.now());
        Product savedProduct = productRepository.save(product);
        System.out.println(savedProduct.toString());
    }
}