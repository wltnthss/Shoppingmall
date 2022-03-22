package com.shoppingmall.dto;

import com.shoppingmall.constant.ProductSellStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductDto {

    private Long id; //상품 코드

    private String productName; // 상품명

    private int price; // 가격

    private String description; // 상품 상세 설명

    private String productSellStatus; // 상품 판매 상태

    private LocalDateTime createdTime; // 등록시간

    private LocalDateTime modifiedTime; // 수정시간
}
