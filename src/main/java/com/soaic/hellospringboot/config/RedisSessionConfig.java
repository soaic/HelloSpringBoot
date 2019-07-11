package com.soaic.hellospringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)//原 Spring Boot 的 server.session.timeout 属性不再生效。
public class RedisSessionConfig {

}
