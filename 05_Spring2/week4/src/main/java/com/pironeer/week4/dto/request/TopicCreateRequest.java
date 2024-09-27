package com.pironeer.week4.dto.request;

import jakarta.validation.constraints.NotNull;

public record TopicCreateRequest(
        @NotNull String title,
        @NotNull String content
) {}