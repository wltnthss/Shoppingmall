package com.shoppingmall.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shoppingmall.constant.ProductSellStatus;
import com.shoppingmall.entity.Notice;
import com.shoppingmall.entity.Product;
import com.shoppingmall.entity.QNotice;
import com.shoppingmall.entity.QProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class NoticeRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    NoticeRepository noticeRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("공지사항 테스트")
    public void createNoticeTest(){
        Notice notice = new Notice();
        notice.setNoticeTitle("테스트 제목");
        notice.setNoticeContent("테스트 본문");
        notice.setNoticeDateTime(LocalDateTime.now());
        notice.setNoticeViewNum(1L);
        Notice savedNotice = noticeRepository.save(notice);
        System.out.println(savedNotice.toString());

    }

    /**
     * Querydsl Test
     */
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

    /**
     * JPA Test
     */
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
        System.out.println(savedProduct);
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
}