package com.pironeer.week4.global.mapper;

import com.pironeer.week4.topic.dto.request.TopicCreateRequest;
import com.pironeer.week4.topic.dto.request.TopicUpdateRequest;
import com.pironeer.week4.topic.entity.Topic;

import java.time.LocalDateTime;

public class TopicMapper {

    // TopicCreateRequest를 Topic 객체로 변환
    public static Topic from(TopicCreateRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Topic.builder()
                .title(request.title())
                .content(request.content())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }

    // TopicUpdateRequest를 Topic 객체로 변환 (수정 시 사용)
    public static Topic from(TopicUpdateRequest request, Topic existingTopic) {
        if (request.title() != null && !request.title().isBlank()) {
            existingTopic.setTitle(request.title());
        }
        if (request.content() != null && !request.content().isBlank()) {
            existingTopic.setContent(request.content());
        }
        existingTopic.setUpdatedAt(LocalDateTime.now());
        return existingTopic;
    }
}