package com.wenhai.foodie.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
*@Author:谢文海
*@Description: aip引导类
*@Date:2019/12/3_23:48
*/
@EnableSwagger2
@MapperScan(basePackages = {"com.wenhai.mapper"})
@SpringBootApplication(scanBasePackages = {"com.wenhai","org.n3r.idworker"})
public class ApiBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ApiBootstrap.class, args);
    }
}
