package com.fenlyin;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @业务描述：
 * @package_name： com.ratel.json.config
 * @project_name： fast-json-test
 * @author： ratelfu@qq.com
 * @create_time： 2019-09-17 17:27
 * @copyright (c) ratelfu 版权所有
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * 是否开启swagger，正式环境一般是需要关闭的 ，使用@value注解从application.yml中获取属性
     */
    @Value("${swagger.enabled}")
    private boolean enableSwagger;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //加了ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //包下的类，才生成接口文档
                //.apis(RequestHandlerSelectors.basePackage("com.ratel.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(security());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：https://blog.csdn.net/weter_drop")
                .termsOfServiceUrl("https://blog.csdn.net/weter_drop/")
                .contact("ratel")
                .version("1.0")
                .build();
    }

    /**
     *添加swagger的安全相关的参数，比如在请求头中添加 token
     * @return
     */
    private List<ApiKey> security() {
        return newArrayList(
                new ApiKey("token", "token", "header")
        );
    }
}