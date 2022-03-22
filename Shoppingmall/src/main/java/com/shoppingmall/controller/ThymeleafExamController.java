package com.shoppingmall.controller;

import com.shoppingmall.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/thymeleaf")   // url에 thymeleaf 경로 요청이 오면 Controller가 역할을 위임
public class ThymeleafExamController {
    @GetMapping(value = "/exam01")
    public String thymeleafExample01(Model model){
        model.addAttribute("data", "타임리프 예제 test");
        return "thymeleafEx/thymeleafEx01";     // templates 폴더 기준으로 뷰의 위치와 이름(thymeleafEx01.html) 반환
    }

    @GetMapping(value = "/exam02")
    public String thymeleafExample02(Model model){
        ProductDto productDto = new ProductDto();
        productDto.setProductName("테스트 상품1");
        productDto.setDescription("상품 설명");
        productDto.setPrice(10000);
        productDto.setCreatedTime(LocalDateTime.now());

        model.addAttribute("productDto", productDto);
        return "thymeleafEx/thymeleafEx02";
    }
}
