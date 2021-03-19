package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springboot启动入口类

/**
 * springboot项目代码必须载application类所在目录或下级目录
 */
@SpringBootApplication//开启springboot配置的注解
public class Application {

    public static void main(String[] args) {
        //将springboot应用启动
        SpringApplication.run(Application.class, args);
    }

}
