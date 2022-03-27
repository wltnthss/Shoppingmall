package com.shoppingmall.controller;

import com.shoppingmall.entity.Notice;
import com.shoppingmall.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/userService")   // url에 thymeleaf 경로 요청이 오면 Controller가 역할을 위임
public class UserServiceController {

    @Autowired
    NoticeRepository noticeRepository;


    @GetMapping(value = "/notice/noticeMain")
    public String thymeleafExample01(Model model){

        List<Notice> noticeList=new ArrayList<>();
        for(int i=0;i<10;i++){
            Notice notice =new Notice();
            notice.setNoticeNum((long) i);
            notice.setNoticeTitle("공지사항 타이틀"+i);
            notice.setNoticeContent("공지사항 내용"+i);
            notice.setNoticeViewNum((long) i);
            notice.setNoticeDateTime(LocalDateTime.now());
            noticeList.add(notice);
            System.out.println(noticeList);
        }

        model.addAttribute("noticeList", noticeList);
        return "userService/notice/noticeMain";     // templates 폴더 기준으로 뷰의 위치와 이름(thymeleafEx01.html) 반환
    }

    @GetMapping(value = "/notice/find")
    public String findByNum(Model model,String test){
        System.out.println(test);
        //noticeRepository.findByNoticeNum(test);

        return "userService/notice/find";
    }

}
