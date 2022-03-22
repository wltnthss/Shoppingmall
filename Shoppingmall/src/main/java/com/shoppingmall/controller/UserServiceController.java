package com.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/userService")   // url에 thymeleaf 경로 요청이 오면 Controller가 역할을 위임
public class UserServiceController {
    @GetMapping(value = "/notice")
    public String thymeleafExample01(Model model){
        model.addAttribute("data", "고객센터 내 공지사항 test");
        return "userService/notice";     // templates 폴더 기준으로 뷰의 위치와 이름(thymeleafEx01.html) 반환
    }
}
