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
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * 启动 redis :
 * docker run -p 6379:6379 -v $PWD/data:/data -d redis redis-server --appendonly yes
 *
 * 启动 mongoDB :
 * docker run -p 27017:27017 -v $PWD/db:/data/db -d mongo
 *
 */
@Controller
@SpringBootApplication
@MapperScan("com.soaic.hellospringboot.mapper")
@EnableCaching
@EnableSwagger2
public class HellospringbootApplication {

    private final static Logger logger = LoggerFactory.getLogger(HellospringbootApplication.class);

    public static void main(String[] args) throws UnknownHostException {

        Environment env = SpringApplication.run(HellospringbootApplication.class, args).getEnvironment();

        logger.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttps://localhost:{}\n\t" +
                        "External: \thttps://{}:{}\n\t" +
                        "Swagger2: \thttps://{}:{}/swagger-ui.html\n" +
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }

    @RequestMapping("/")
    public String test() {
        return "hello.html";
    }

}
