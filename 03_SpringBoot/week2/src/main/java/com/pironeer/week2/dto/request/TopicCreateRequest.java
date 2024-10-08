package com.pironeer.week2.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record TopicCreateRequest(
        @NotNull
        @Schema(
                description = "게시물 제목",
                example = "제목입니다",
                type = "string",
                requiredMode = Schema.RequiredMode.REQUIRED)
        String title,
        @Schema(
                description = "게시물 내용",
                example = "내용입니다",
                type = "string",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        String content) {
}