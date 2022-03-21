package com.shoppingmall.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNotice is a Querydsl query type for Notice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNotice extends EntityPathBase<Notice> {

    private static final long serialVersionUID = -496845570L;

    public static final QNotice notice = new QNotice("notice");

    public final StringPath NoticeContent = createString("NoticeContent");

    public final DateTimePath<java.time.LocalDateTime> NoticeDateTime = createDateTime("NoticeDateTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> NoticeNum = createNumber("NoticeNum", Long.class);

    public final StringPath NoticeTitle = createString("NoticeTitle");

    public final NumberPath<Long> NoticeViewNum = createNumber("NoticeViewNum", Long.class);

    public QNotice(String variable) {
        super(Notice.class, forVariable(variable));
    }

    public QNotice(Path<? extends Notice> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNotice(PathMetadata metadata) {
        super(Notice.class, metadata);
    }

}

