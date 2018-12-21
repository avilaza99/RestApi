package com.exercise.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean public Docket inventoryItemApi(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.exercise.api")).paths(regex("/inventory.*"))
                .build().apiInfo(metadata());
    }

    private ApiInfo metadata(){
        return new ApiInfo("Spring Boot REST API","Spring Boot REST API for Inventory Item Catalog","1.0",ApiInfo.DEFAULT.getTermsOfServiceUrl(),
        new Contact("Jonathan Avila","https://www.linkedin.com/in/jonathanavilasalazar","avilaza99@yahoo.com.mx"),ApiInfo.DEFAULT.getLicense(),ApiInfo.DEFAULT.getLicenseUrl(),ApiInfo.DEFAULT.getVendorExtensions());
    }
}
