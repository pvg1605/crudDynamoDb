package com.app.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 
 * @author praveenv
 *
 *This configuration is to integrate Swagger 2 into an existing Spring Boot project
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * After the Docket bean is defined, its select() method returns an instance of ApiSelectorBuilder, 
	 * which provides a way to control the endpoints exposed by Swagger
	 * Predicates for selection of RequestHandlers can be configured with the help of RequestHandlerSelectors and PathSelectors
	 * 
	 * @return Docket instance
	 */
	@Bean
	public Docket swaggerConfiguration() {
		
		return new  Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/users/*"))
				.apis(RequestHandlerSelectors.basePackage("com.app"))
				.build()
				.apiInfo(apiDetails());
	}
	
	/**
	 * This method let you write API Details.
	 * 
	 * @return API information
	 */
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Crud API", 
				"Sample API using DynamoDB",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Praveen V","http://app.com","praveen.v@practo.com"), 
				"API License",
				"http://app.com",
				Collections.emptyList()
				);
	}
}
