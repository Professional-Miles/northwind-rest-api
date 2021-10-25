package com.sparta.ml.northwindrest;

import com.fasterxml.classmate.TypeResolver;
import com.sparta.ml.northwindrest.dto.CategoryDTO;
import com.sparta.ml.northwindrest.dto.CustomerDTO;
import com.sparta.ml.northwindrest.dto.EmployeeDTO;
import com.sparta.ml.northwindrest.dto.ProductDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sparta.ml.northwindrest.controllers"))
                .paths(regex("/northwind.*"))
                .build()
                .apiInfo((metaData()));
    }

    private ApiInfo metaData() {
        return new ApiInfo(
                "Sprint Boot REST API",
                "Spring Boot REST API for Northwind database",
                "1.0",
                "https://www.spri.ng/policies/spring-terms-of-service?section=terms-of-service",
                "Miles",
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
    }
}



