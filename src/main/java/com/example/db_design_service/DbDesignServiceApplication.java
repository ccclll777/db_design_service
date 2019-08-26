package com.example.db_design_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 * spring boot 启动类
 *
 *
 *
 */
@SpringBootApplication
@MapperScan("org.sang.mapper")
@EnableCaching
public class DbDesignServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbDesignServiceApplication.class, args);
    }

}
