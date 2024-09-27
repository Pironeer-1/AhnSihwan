package com.pironeer.week4.global.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class ExceptionResult {

    @Getter
    @Setter
    @Builder
    public static class ServerErrorData {

        @Schema(description = "오류 발생 클래스", example = "org.example.XX")
        private String errorClass;

        @Schema(description = "오류 메세지")
        private String errorMessage;
    }
}
