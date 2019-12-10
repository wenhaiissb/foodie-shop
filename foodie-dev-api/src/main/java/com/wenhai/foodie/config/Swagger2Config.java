package com.wenhai.foodie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {


    /**
     *  url :http://ip:port/swagger-ui.html
     *  http://wenhai.mynatapp.cc/doc.html
     * @return
     */
    @Bean
    public Docket docket(){
        /**
         *       String title,
         *       String description,
         *       String version,
         *       String termsOfServiceUrl,
         *       Contact contact,
         *       String license,
         *       String licenseUrl
         */
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("天天吃货") // 主题
                        .description("天天电商平台")
                        .contact(new Contact("谢文海","http://wenhai.mynatapp.cc","418480642@qq.com"))
                        .version("1")
                        .termsOfServiceUrl("http://wenhai.mynatapp.cc")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wenhai.foodie.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
