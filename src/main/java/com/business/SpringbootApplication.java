package com.business;

import com.business.config.StartHelper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@SpringBootApplication
@MapperScan(value = "com.business.mapper")
public class SpringbootApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootApplication.class, args);
        StartHelper.printStartInfo(log, run);
    }
}
