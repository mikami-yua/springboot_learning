package com.example.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器,重写以下三种方法
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    /**
     * 只需要重写这个方法，因为需要放行
     * @param request
     * @param response
     * @param handler
     * @return true放行、false不放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.登录成功之后应该有用户的session，如果有session就说明用户登录了，否则说明没有登录
        Object loginUser=request.getSession().getAttribute("loginUser");
        if (loginUser == null) {//没有登录
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
