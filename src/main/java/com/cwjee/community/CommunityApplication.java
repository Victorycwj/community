package com.cwjee.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cwjee.community.mapper")
public class CommunityApplication {


    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }



}
