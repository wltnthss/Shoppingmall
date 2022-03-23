package com.shoppingmall.repository;

import com.shoppingmall.entity.Notice;
import com.shoppingmall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice,Long>, QuerydslPredicateExecutor<Notice> {
   List<Notice> findByNoticeTitle(String NoticeTitle);
   List<Notice> findByNoticeNum(String NoticeNum);
}
