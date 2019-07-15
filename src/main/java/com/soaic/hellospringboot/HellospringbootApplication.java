package com.soaic.hellospringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
@SpringBootApplication
@MapperScan("com.soaic.hellospringboot.mapper")
@EnableCaching
public class HellospringbootApplication {

    private final static Logger logger = LoggerFactory.getLogger(HellospringbootApplication.class);

    public static void main(String[] args) throws UnknownHostException {

        Environment env = SpringApplication.run(HellospringbootApplication.class, args).getEnvironment();

        logger.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttps://localhost:{}\n\t" +
                        "External: \thttps://{}:{}\n" +
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }

    @RequestMapping("/")
    public String test() {
        return "hello.html";
    }

}
