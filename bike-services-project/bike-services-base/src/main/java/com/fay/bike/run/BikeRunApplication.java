package com.fay.bike.run;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 启动服务
 * @author fanqingfeng
 * @date 2018/11/9 18:01
 */
@ImportResource("classpath:spring-mybatis.xml")
@MapperScan("com.fay.bike.services.**.mapper")
@SpringBootApplication(scanBasePackages = "com.fay.bike")
public class BikeRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(BikeRunApplication.class, args);
    }
}
