package com.dc18669.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// @SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        System.out.println("预备启动 Student，，，，，，>>>");
        System.out.println("启动中 Student，，，，，，>>>");
        System.out.println("启动完成 Student，，，，，，>>>");
        System.out.println("预备编译 Student，，，，，，>>>");
        SpringApplication.run(SpringBootDemoApplication.class, args);
        System.out.println("编译中 Student，，，，，，>>>");
        System.out.println("编译完成 Student，，，，，，>>>");
    }

}
