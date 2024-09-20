package com.pironeer.week2.dto.request;

public record CommentCreateRequest(Long parentId, Long topicId, String content) {}