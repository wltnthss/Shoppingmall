package com.shoppingmall.repository;

import com.shoppingmall.entity.Notice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class NoticeRepositoryTest {

    @Autowired
    NoticeRepository noticeRepository;

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
}