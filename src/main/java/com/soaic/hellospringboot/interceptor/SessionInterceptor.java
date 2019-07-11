package com.soaic.hellospringboot.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Component("sessionInterceptor")
public class SessionInterceptor implements HandlerInterceptor {

    /**
     * 1. 该方法将在请求处理之前进行调用
     * 2. 返回true会执行下一个Interceptor
     * 3. 返回false则不会执行下一个Interceptor也不会执行Controller里的方法
     * 4. 先声明的Interceptor的preHandle方法会先执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("SessionInterceptor preHandle");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            return true;
        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.write("{code: 501, message:\"not login!\"}");
            return false;
        }
        //return true;
    }

    /**
     * 1. 该方法将在当前请求进行处理之后调用
     * 2. 且preHandle方法返回为true
     * 3. 先声明的Interceptor的postHandle方法会后执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("SessionInterceptor postHandle");
    }

    /**
     * 1. 该方法将在请求完成之后调用
     * 2. 同样且需要preHandle方法返回为true
     * 3. 一般用于进行资源清理
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("SessionInterceptor afterCompletion");
    }

}
