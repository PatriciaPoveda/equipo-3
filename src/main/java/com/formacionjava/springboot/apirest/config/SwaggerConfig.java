package com.formacionjava.springboot.apirest.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.Collections;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.apis(RequestHandlerSelectors.basePackage("com.formacionjava.springboot.apirest.controllers"))
	.paths(PathSelectors.any())
	.build();
	}


	/*private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Team III",
				"Ejercicio empleados",
				"1.0",
				"http://capgemini.com",
				new Contact("Codmind", "https://capgemini.com", "patricia.poveda-boto@capgemini.com"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()*/
				//);

//	}


//	}


}


