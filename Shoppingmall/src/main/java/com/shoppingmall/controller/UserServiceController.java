package com.shoppingmall.controller;

import com.shoppingmall.dto.NoticeDto;
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


    @GetMapping(value = "/notice/noticeMainEx02")
    public String thymeleafExample02(Model model) {

        NoticeDto noticeDto = new NoticeDto();
        noticeDto.setNoticeTitle("공지사항 타이틀");
        noticeDto.setNoticeContent("공지사항 내용");
        noticeDto.setNoticeDateTime(LocalDateTime.now());

        model.addAttribute("noticeDto", noticeDto);
        return "userService/notice/noticeMainEx02";     // templates 폴더 기준으로 뷰의 위치와 이름(thymeleafEx01.html) 반환
    }

    @GetMapping(value = "/notice/noticeMainEx03")
    public String thymeleafExample03(Model model) {

        List<NoticeDto> noticeDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NoticeDto noticeDto = new NoticeDto();
            noticeDto.setNoticeNum((long) i);
            noticeDto.setNoticeTitle("공지사항 타이틀" + i);
            noticeDto.setNoticeContent("공지사항 내용" + i);
            noticeDto.setNoticeDateTime(LocalDateTime.now());
            noticeDto.setNoticeViewNum((long) i);
            noticeDtoList.add(noticeDto);
        }


        model.addAttribute("noticeDtoList", noticeDtoList);
        return "userService/notice/noticeMainEx03";     // templates 폴더 기준으로 뷰의 위치와 이름(thymeleafEx01.html) 반환
    }

    @GetMapping(value = "/notice/noticeMainEx04")
    public String thymeleafExample04(Model model) {

        List<NoticeDto> noticeDtoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NoticeDto noticeDto = new NoticeDto();
            noticeDto.setNoticeNum((long) i);
            noticeDto.setNoticeTitle("공지사항 타이틀" + i);
            noticeDto.setNoticeContent("공지사항 내용" + i);
            noticeDto.setNoticeDateTime(LocalDateTime.now());
            noticeDto.setNoticeViewNum((long) i);
            noticeDtoList.add(noticeDto);
        }


        model.addAttribute("noticeDtoList", noticeDtoList);
        return "userService/notice/noticeMainEx04";     // templates 폴더 기준으로 뷰의 위치와 이름(thymeleafEx01.html) 반환
    }


    @GetMapping(value = "/notice/noticeMainEx05")
    public String thymeleafExample05(Model model) {

        return "userService/notice/noticeMainEx05";     // templates 폴더 기준으로 뷰의 위치와 이름(thymeleafEx01.html) 반환
    }


    @GetMapping(value = "/notice/noticeMainEx06")
    public String thymeleafExample06(String param1,String param2, Model model) {
        model.addAttribute("param1",param1);
        model.addAttribute("param2",param2);

        return "userService/notice/noticeMainEx06";     // templates 폴더 기준으로 뷰의 위치와 이름(thymeleafEx01.html) 반환
    }

    @GetMapping(value = "/notice/noticeMainEx07")
    public String thymeleafExample07() {
        return "userService/notice/noticeMainEx07";     // templates 폴더 기준으로 뷰의 위치와 이름(thymeleafEx01.html) 반환
    }
}
