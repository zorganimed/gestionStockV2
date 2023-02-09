package com.mzo.gestiondestock.config;


import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.mzo.gestiondestock.utils.Constants.APP_ROOT;

@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket api() {
		System.out.println("inside docket+88+");
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(
						new ApiInfoBuilder()
						.description("Gestion de stock api documentation")
						.title("Gestion de stock REST API")
						.build()
						)
				        .groupName("REST API V1")
				        .select()
				        .apis(RequestHandlerSelectors.basePackage("com.mzo.gestiondestock"))
				        .paths(PathSelectors.ant(APP_ROOT+ "/**"))
				        .build()
				;
	}

}
