package com.pironeer.week2.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record TopicUpdateRequest(
        @NotNull
        @Schema(
                description = "게시물 ID",
                example = "1",
                type = "long",
                requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,
        @Schema(
                description = "수정할 게시물 제목",
                example = "제목을 수정합니다",
                type = "string",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        String title,
        @Schema(
                description = "수정할 게시물 내용",
                example = "내용을 수정합니다",
                type = "string",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        String content) {
}
