package com.example.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 国际化解析器
 */
public class MyLocaleResolver implements LocaleResolver {
    /**
     * 解析请求
     * @param httpServletRequest
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获得请求中的参数连接（语言参数）
        String language = httpServletRequest.getParameter("l");
        Locale locale=Locale.getDefault();//默认的
        //如果没有就使用默认的  请求连接有参数需要判断了
        if(!StringUtils.isEmpty(language)){
            String[] splits=language.split("_");
            //国家地区 zh_CN
            locale=new Locale(splits[0],splits[1]);
        }
        return locale;

    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
