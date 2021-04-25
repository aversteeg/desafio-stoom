package br.com.stoom;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoomApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		//Return a prepared Docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.apis(RequestHandlerSelectors.basePackage("br.com.stoom"))
				.build()
				.apiInfo(apiDetails());
				
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo("Desafio Stoom", 
				"Desafio Back End", 
				"1.0.0", 
				"Livre para uso", 
				new springfox.documentation.service.Contact("Anderson", "github.com/aversteeg", "anderson_versteeg@hotmail.com"), 
				"API License",
				"www.linkedin.com/in/anderson-versteeg",
				Collections.emptyList());
	}

}
