package com.pironeer.week4.topic.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Topic {
    private Long id; // 게시물 ID
    private String title; // 제목
    private String content; // 내용
    private LocalDateTime createdAt; // 생성 시간
    private LocalDateTime updatedAt; // 수정 시간

    @Builder
    public Topic(Long id, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}