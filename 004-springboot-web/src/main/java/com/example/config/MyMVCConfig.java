package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * 全面扩展springmvc
 * @Configuration 使这个类变成一个配置类
 * implements WebMvcConfigurer 实现接口（接口中是可以重写的方法，这些方法可以重新配置springmvc）
 * 通过重写方法实现扩展功能
 *
 *  如果想要一些定制化的功能，只需要写这个组件，交给springboot，springboot就会自动装配
 *
 *  public interface ViewResolver 实现了视图解析器接口的类，就可以把它看作视图解析器
 *      手动接管
 */
@Configuration
public class MyMVCConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    /**
     * 自定义属视图解析器
     */
    public static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}

