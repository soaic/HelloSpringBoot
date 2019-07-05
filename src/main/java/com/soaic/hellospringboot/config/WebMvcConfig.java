package com.soaic.hellospringboot.config;

import com.soaic.hellospringboot.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/register", "/user/login", "/error");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //配置页面转向 通过地址http://localhost:8088/hello 可以转向到templates/hello.html
        registry.addViewController("/hello").setViewName("hello");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //资源映射处理 通过地址http://localhost:8088/images/xx 可以访问/images/目录下的资源
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
    }
}
