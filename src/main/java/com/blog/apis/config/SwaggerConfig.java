package com.blog.apis.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
	
	
	
	 @Bean
	    public OpenAPI customOpenAPI() {
		 
		 String schemeName = "bearerScheme";
	        return new OpenAPI()
	        		.addSecurityItem(new SecurityRequirement()
	        		.addList(schemeName)		
	        				)
	        		.components(new Components()
	        				.addSecuritySchemes(schemeName, new SecurityScheme()
	        				.name(schemeName)	
	        				.type(SecurityScheme.Type.HTTP)
	        				.bearerFormat("JWT")
	        				.scheme("bearer")
	        						))
	        		
	                .info(new Info()
	                        .title("Blogging App API's Application")
	                        .version("1.0")
	                        .description("Blogging App API's Documentation")
	                        .termsOfService("http://swagger.io/terms/")
	                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
	    }

	    @Bean
	    public GroupedOpenApi publicApi() {
	        return GroupedOpenApi.builder()
	                .group("public")
	                .pathsToMatch("/api/**")
	                .build();
	    }

}
