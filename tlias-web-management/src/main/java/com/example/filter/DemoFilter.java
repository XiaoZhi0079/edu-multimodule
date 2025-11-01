package com.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


//@WebFilter(urlPatterns ="/*")
@Slf4j
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init初始");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter过滤");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }


    //销毁方法，web服务器关闭时执行
    @Override
    public void destroy() {
        Filter.super.destroy();
        log.info("destroy销毁");
    }
}

