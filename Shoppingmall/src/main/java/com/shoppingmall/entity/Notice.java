package com.shoppingmall.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "notice")
@Getter
@Setter
@ToString
public class Notice {

    @Id
    @Column(name = "notice_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long noticeNum; // 공지사항 번호

    @Column(nullable = false, length = 50)
    private String noticeTitle; // 공지사항 제목

    @Lob
    @Column(nullable = false)
    private String noticeContent; // 공지사항 본문

    @Column(nullable = false)
    private Long noticeViewNum; // 공지사항 조회수

    @Column(nullable = false)
    private LocalDateTime noticeDateTime; // 공지사항 등록날짜


}
