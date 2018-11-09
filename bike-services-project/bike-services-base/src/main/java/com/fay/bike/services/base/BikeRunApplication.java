package com.fay.bike.services.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动服务
 * @author fanqingfeng
 * @date 2018/11/9 18:01
 */
@ComponentScan(basePackages = "com.fay.bike")
@MapperScan("com.fay.bike.services.*.mapper")
@SpringBootApplication
public class BikeRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(BikeRunApplication.class, args);
    }
}
