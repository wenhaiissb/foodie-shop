package com.wenhai.foodie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
*@Author:谢文海
*@Description: 跨域
*@Date:2019/12/8_0:42
*/
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        corsConfiguration.addAllowedOrigin("http://localhost:8080");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}
