package com.shoppingmall.controller;

import com.shoppingmall.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/thymeleaf")   // url에 thymeleaf 경로 요청이 오면 Controller가 역할을 위임
public class ThymeleafExamController {
    @GetMapping(value = "/exam01")
    public String thymeleafExample01(Model model) {
        model.addAttribute("data", "타임리프 예제 test");
        return "thymeleafEx/thymeleafEx01";     // templates 폴더 기준으로 뷰의 위치와 이름(thymeleafEx01.html) 반환
    }

    @GetMapping(value = "/exam02")
    public String thymeleafExample02(Model model) {
        ProductDto productDto = new ProductDto();
        productDto.setProductName("테스트 상품1");
        productDto.setDescription("상품 설명");
        productDto.setPrice(10000);
        productDto.setCreatedTime(LocalDateTime.now());

        model.addAttribute("productDto", productDto);
        return "thymeleafEx/thymeleafEx02";
    }

    @GetMapping(value = "/exam03")
    public String thymeleafExample03(Model model) {
        List<ProductDto> productDtoList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            ProductDto productDto = new ProductDto();
            productDto.setProductName("테스트 상품1" + i);
            productDto.setDescription("상품 설명" + i);
            productDto.setPrice(10000 * i);
            productDto.setCreatedTime(LocalDateTime.now());

            productDtoList.add(productDto);
        }

        model.addAttribute("productDtoList", productDtoList);
        return "thymeleafEx/thymeleafEx03";
    }

    @GetMapping(value = "/exam04")
    public String thymeleafExample04(Model model) {
        List<ProductDto> productDtoList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            ProductDto productDto = new ProductDto();
            productDto.setProductName("테스트 상품1" + i);
            productDto.setDescription("상품 설명" + i);
            productDto.setPrice(10000 * i);
            productDto.setCreatedTime(LocalDateTime.now());

            productDtoList.add(productDto);
        }

        model.addAttribute("productDtoList", productDtoList);
        return "thymeleafEx/thymeleafEx04";
    }

    @GetMapping(value = "/exam05")
    public String thymeleafExample05(Model model) {
        return "thymeleafEx/thymeleafEx05";
    }

    @GetMapping(value = "/exam06")
    public String thymeleafExample06(String param1, String param2, Model model) {
        model.addAttribute("pg", param1);
        model.addAttribute("seq", param2);
        return "thymeleafEx/thymeleafEx06";
    }

    @GetMapping(value = "/exam07")
    public String thymeleafExample07(){
        return "thymeleafEx/thymeleafEx07";
    }
}
