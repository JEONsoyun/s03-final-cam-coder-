package com.coder.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public UiConfiguration uiConfig() {
		return UiConfiguration.DEFAULT;
	}
	
	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("CamCoder Api List")
				.description("Spring Boot Rest API")
				.version("1.0")
				.build();
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("basic").select()
				.apis(RequestHandlerSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error.*?"))).build().apiInfo(metadata());
	}
	
	//PathSelectors.any()regex("/sns/.*")
}
