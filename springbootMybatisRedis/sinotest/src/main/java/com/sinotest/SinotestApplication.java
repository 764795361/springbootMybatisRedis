package com.sinotest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 86136
 */
@SpringBootApplication
@MapperScan(basePackages = "com.sinotest.mapper")
public class SinotestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinotestApplication.class, args);
    }

}
