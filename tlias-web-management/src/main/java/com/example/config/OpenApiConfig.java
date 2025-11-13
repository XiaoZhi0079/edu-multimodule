package com.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("在线教育系统API")
                .description("This is a custom API documentation.")
                .version("1.0.0").contact(new Contact().name("XiaoZhi")
                .url("小智的网站").email("dashuaige0079@Gmail.com"))
                .license(new License().name("Apache 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}