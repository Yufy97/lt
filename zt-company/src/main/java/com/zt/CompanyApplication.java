package com.zt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.zt.mapper")
@EnableFeignClients(basePackages = "com.zt.client")
public class CompanyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);
    }
}
