package com.example.dssdapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@SecurityScheme(
	    name = "bearerAuth",
	    type = SecuritySchemeType.HTTP,
	    bearerFormat = "JWT",
	    scheme = "bearer"
	)
public class SwaggerConfig {

	@Bean
	public OpenAPI springGlobalFurnitureOpenAPI() {
		return new OpenAPI()
        .info(new Info().title("API Global Furniture")
        .description("API Global furniture")
        .version("v0.0.1"));
	}
}
