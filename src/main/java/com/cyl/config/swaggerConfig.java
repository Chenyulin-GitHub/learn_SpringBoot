package com.cyl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //表示当前类是一个配置类
@EnableSwagger2 //表示启用 swagger API文档
public class swaggerConfig {

    @Bean
    public Docket createRestApi(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描BasePackage包下面“/User/.*”路径下的内容作为接口文档构建的目标
                .apis(RequestHandlerSelectors.basePackage("com.cyl"))
                .paths(PathSelectors.regex("/User/.*"))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Learn_SpringBoot(Springboot利用swagger构建api文档)")
                .description("简单优雅的restfun风格")
                .termsOfServiceUrl("www.baidu.com")
                .version("1.0")
                .build();
    }

}
