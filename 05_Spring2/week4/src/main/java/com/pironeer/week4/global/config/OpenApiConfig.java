package com.pironeer.week4.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Pironeer Week4 API 명세서",
                description = "API 명세서",
                version = "v1",
                contact = @Contact(
                        name = "안시환"
                )
        )
)
@Configuration
public class OpenApiConfig {
}