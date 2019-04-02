package com.example.demo.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/2  12:39.
 * @Modified by:
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport{
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/","classpath:/META-INF/resources/webjars/","classpath:/static/","classpath:/templates/");
    }
}
