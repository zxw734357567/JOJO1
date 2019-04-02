package com.example.demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/2  10:52.
 * @Modified by:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}


/*
Note :
@Configuration 是告诉 Spring Boot 需要加载这个配置类，@EnableSwagger2 是启用 Swagger2，如果没加的话自然而然也就看不到后面的验证效果了。
建造者模式可以深入了解,使用频繁
*/