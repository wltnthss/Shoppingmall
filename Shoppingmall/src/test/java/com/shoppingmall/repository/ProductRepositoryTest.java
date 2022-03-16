package com.shoppingmall.repository;

import com.shoppingmall.constant.ProductSellStatus;
import com.shoppingmall.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ProductRepository Test
 * @ 2022-03-16 손지수
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
        product.setProductName("테스트 상품");
        product.setPrice(1000);
        product.setDescription("테스트 상품 설명");
        product.setProductSellStatus(ProductSellStatus.SELL);
        product.setStockNumber(100);
        product.setCreatedTime(LocalDateTime.now());
        product.setModifiedTime(LocalDateTime.now());
        Product savedProduct = productRepository.save(product);
        System.out.println(savedProduct.toString());
    }

    public void createProductList(){
        for(int i=1; i<10; i++){
            Product product = new Product();
            product.setProductName("테스트 상품" + i);
            product.setPrice(10000 + i);
            product.setDescription("테스트 상품 설명" + i);
            product.setProductSellStatus(ProductSellStatus.SELL);
            product.setStockNumber(100);
            product.setCreatedTime(LocalDateTime.now());
            product.setModifiedTime(LocalDateTime.now());
            Product savedProduct = productRepository.save(product);
        }
    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByProductNameTest(){
        this.createProductList();
        List<Product> productList = productRepository.findByProductName("테스트 상품1");
        for(Product product : productList){
            System.out.println(product.toString());
        }
    }
}