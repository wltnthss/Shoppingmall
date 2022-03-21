package com.shoppingmall.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shoppingmall.constant.ProductSellStatus;
import com.shoppingmall.entity.Product;
import com.shoppingmall.entity.QProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ProductRepository Test
 * @ 2022-03-16 손지수
 */
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")    //application.properties 보다 높은 우선순위이기 때문에 사용함
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @PersistenceContext
    EntityManager em;

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

    public void createProductList2(){
        for(int i=1; i<=5; i++){
            Product product = new Product();
            product.setProductName("테스트 상품" + i);
            product.setPrice(10000 + i);
            product.setDescription("테스트 상품 설명" + i);
            product.setProductSellStatus(ProductSellStatus.SELL);
            product.setStockNumber(100);
            product.setCreatedTime(LocalDateTime.now());
            product.setModifiedTime(LocalDateTime.now());
            productRepository.save(product);
        }

        for(int i=6; i<=10; i++){
            Product product = new Product();
            product.setProductName("테스트 상품" + i);
            product.setPrice(10000 + i);
            product.setDescription("테스트 상품 설명" + i);
            product.setProductSellStatus(ProductSellStatus.SOLD_OUT);
            product.setStockNumber(100);
            product.setCreatedTime(LocalDateTime.now());
            product.setModifiedTime(LocalDateTime.now());
            productRepository.save(product);
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

    @Test
    @DisplayName("상품명, 상품상세설명 테스트")
    public void findByProductNameOrDescriptionTest(){
        createProductList();
        List<Product> productList =
                productRepository.findByProductNameOrDescription("테스트 상품1", "테스트 상세 설명5");
        for(Product product : productList){
            System.out.println(product.toString());
        }
    }

    @Test
    @DisplayName("가격 LessThan 테스트")
    public void findByPriceLessThanTest(){
        createProductList();
        List<Product> productList =
                productRepository.findByPriceLessThan(10005);
        for (Product product : productList){
            System.out.println(product.toString());
        }
    }

    @Test
    @DisplayName("@Query를 이용한 상품 조회 테스트")
    public void findByDescriptionTest(){
        createProductList();
        List<Product> productList =
                productRepository.findByDescription("테스트 상세 설명");
        for(Product product : productList){
            System.out.println(product.toString());
        }
    }

    @Test
    @DisplayName("Querydsl 조회 테스트1")
    public void queryDslTest(){
        this.createProductList();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QProduct qProduct = QProduct.product;
        JPAQuery<Product> query = queryFactory.selectFrom(qProduct)
                .where(qProduct.productSellStatus.eq(ProductSellStatus.SELL))
                .where(qProduct.description.like("%" + "테스트 상세 설명" + "%"))
                .orderBy(qProduct.price.desc());

        List<Product> productList = query.fetch();

        for(Product product : productList){
            System.out.println(product.toString());
        }
    }

    // 1~5는 SELL 상태 6~10은 품절상태 리스트
    @Test
    @DisplayName("Querydsl 조회 테스트2")
    public void queryDslTest2(){
        this.createProductList2();

        BooleanBuilder booleanBuilder = new BooleanBuilder(); // 쿼리에 들어갈 조건을 만들어주는 빌더
        QProduct product = QProduct.product;
        String description = "테스트 상품 설명";
        int price = 10004;
        String productSellStat = "SELL";


        booleanBuilder.and(product.description.like("%" + description + "%"));
        booleanBuilder.and(product.price.gt(price));

        if(StringUtils.equals(productSellStat, ProductSellStatus.SELL)){
            booleanBuilder.and(product.productSellStatus.eq(ProductSellStatus.SELL));
        }

        Pageable pageable = PageRequest.of(0, 5);   // 조회할 페이지 번호, 한 페이지당 조회할 데이터 개수
        Page<Product> productPagingResult =
                productRepository.findAll(booleanBuilder, pageable);
        System.out.println("total elements : " +
                productPagingResult.getTotalElements());
        List<Product> resultProductList = productPagingResult.getContent();
        for(Product resultProduct: resultProductList){
            System.out.println(resultProduct.toString());
        }
    }
}