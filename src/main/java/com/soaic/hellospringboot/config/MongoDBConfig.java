package com.soaic.hellospringboot.config;

import com.mongodb.MongoClientOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDBConfig {

    @Bean
    public MongoClientOptions mongoOptions() {
        //解决 Prematurely reached end of stream 异常
        return MongoClientOptions.builder().maxConnectionIdleTime(6000).build();
    }

}
