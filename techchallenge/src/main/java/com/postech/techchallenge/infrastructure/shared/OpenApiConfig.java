package com.postech.techchallenge.infrastructure.shared;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI locatech() {
        return new OpenAPI().info(
                new Info().title("TechChallenge API")
                    // TODO: .description("insert description here")
                    // TODO  .license(new License().name("ver se vai adicionar"))
                    .version("v0.0.1"));
    }

}
