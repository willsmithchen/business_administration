package com.business.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public Knife4jConfiguration(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Bean(value = "dockerBean")
    public Docket dockerBean() {
        //指定使用Swagger2规范
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        //描述字段支持Markdown语法
                        .description("# 企业管理接口文档")
                        .termsOfServiceUrl("https://xxx.com/")
                        .contact(new Contact("铁蛋", "", "chenlujia_123@163.com"))
                        .version("1.0")
                        .build()).extensions(openApiExtensionResolver.buildSettingExtensions())
                //分组名称
                .groupName("用户服务")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.business.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

   /* @Bean(value = "dockerBeanOne")
    public Docket dockerBeanOne() {
        //指定使用Swagger2规范
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        //描述字段支持Markdown语法
                        .description("# 企业管理接口open文档")
                        .termsOfServiceUrl("https://xxx.com/")
                        .contact(new Contact("铁蛋", "", "chenlujia_123@163.com"))
                        .version("1.0.0")
                        .build()).extensions(openApiExtensionResolver.buildSettingExtensions())
                //分组名称
                .groupName("外部用户服务")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.business.controller_b"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }*/
}
