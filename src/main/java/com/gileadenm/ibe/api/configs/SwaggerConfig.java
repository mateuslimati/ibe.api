package com.gileadenm.ibe.api.configs;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket ibeApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.gileadenm.ibe.api"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Instituto Biblico Emanuel API", 
				"API REST de controle de turmas",
				"1.0", 
				"Terms of Service", 
				new Contact("Mateus Lima Alves", "https://www.youtube.com/channel/UCsP3h8zAm76yVMJSmw6-RQw", "mateuslima.ti@gmail.com"), 
				"Apache Licence Version 2.0", 
				"http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>()
		);
		
		return apiInfo;
	}
	
}
