package com.pironeer.week4.topic.dto.request;

import jakarta.validation.constraints.NotNull;

public record TopicUpdateRequest(
        @NotNull Long id,
        String title,
        String content
) {}