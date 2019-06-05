package com.soaic.hellospringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.soaic.hellospringboot.mapper")
public class HellospringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellospringbootApplication.class, args);
    }

    @RequestMapping("/")
    public String test() {
        return "Hello SpringBoot";
    }

}
