package com.zt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.zt.client")
@MapperScan("com.zt.mapper")
public class GraduateApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraduateApplication.class, args);
    }
}
