package com.shoppingmall.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NoticeDto {

    private Long noticeNum; // 공지사항 번호

    private String noticeTitle; // 공지사항 제목

    private String noticeContent; // 공지사항 본문

    private Long noticeViewNum; // 공지사항 조회수

    private LocalDateTime noticeDateTime; // 공지사항 등록날짜
}
