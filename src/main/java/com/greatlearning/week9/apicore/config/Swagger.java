package com.greatlearning.week9.apicore.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {

    @Bean
    public Docket SwaggerDocket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).groupName("Restaurant APIs")
                .select().apis(RequestHandlerSelectors.basePackage("com.greatlearning.week9.controller"))
                .build();
    }

    private ApiInfo getApiInfo(){
        return new ApiInfoBuilder().title("GreatLearning Week 10 - FestiveSale API")
                .description("API Documentation")
                .license("Licensed toStark Industries Pvt. Ltd.")
                .build();
    }

}