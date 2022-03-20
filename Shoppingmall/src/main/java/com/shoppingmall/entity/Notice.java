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
    private Long NoticeNum; // 공지사항 번호

    @Column(nullable = false, length = 50)
    private String NoticeTitle; // 공지사항 제목

    @Lob
    @Column(nullable = false)
    private String NoticeContent; // 공지사항 본문

    @Column(nullable = false)
    private Long NoticeViewNum; // 공지사항 조회수

    @Column(nullable = false)
    private LocalDateTime NoticeDateTime; // 공지사항 등록날짜


}
