package com.shoppingmall.entity;

import com.shoppingmall.constant.ProductSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 상품 변수 선언 Product Class 파일
 * @ 2022-03-15 손지수
 */

@Entity // JPA 엔티티 클래스 설정
@Table(name = "Product")    // product테이블과 매핑
@Getter
@Setter
@ToString
public class Product {

    @Id // 기본키 설정
    @Column(name = "p_id") // 테이블에 매핑될 컬럼 -> product 클래스 id 변수, product 테이블 item_id 매핑 설정
    @GeneratedValue(strategy = GenerationType.AUTO) // JPA 구현체가 자동으로 기본키 생성
    private Long id; //상품 코드

    @Column(nullable = false, length = 50)
    private String p_name; // 상품명

    @Column(name = "price", nullable = false)
    private int price; // 가격

    @Column(nullable = false)
    private int stock_number; // 재고수량

    @Lob
    @Column(nullable = false)
    private String description; // 상품 상세 설명

    @Enumerated(EnumType.STRING)    // JPA 데이터베이스 저장시 String 형태로 저장 선언
    private ProductSellStatus product_sell_status; // 상품 판매 상태

    private LocalDateTime created_date; // 등록시간

    private LocalDateTime modified_date; // 수정 시간
}
