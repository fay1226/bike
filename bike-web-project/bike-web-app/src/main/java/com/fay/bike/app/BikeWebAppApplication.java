package com.fay.bike.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动APP
 * @author fanqingfeng
 * @date 2018/11/5 17:48
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.fay.bike.services.*"})
public class BikeWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BikeWebAppApplication.class, args);
    }
}
