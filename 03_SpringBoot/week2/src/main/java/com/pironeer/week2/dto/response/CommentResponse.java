package com.pironeer.week2.dto.response;

import com.pironeer.week2.repository.domain.Comment;

import java.time.LocalDateTime;

public record CommentResponse(
        Long id,
        Long topicId,
        String content,
        Long parentId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

    // Comment 객체를 CommentResponse로 변환하는 of 메서드
    public static CommentResponse of(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                comment.getTopicId(),
                comment.getContent(),
                comment.getParentId(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }
}