package com.example.filter;

import com.example.utils.JWT;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取请求路径
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //判断路径，是否放行
        String path = request.getRequestURI();
        if (path.contains("login")) {
            log.info("登录请求,放行");
            filterChain.doFilter(request, response);
            return;
        }
        //获取token
        String token = request.getHeader("token");
        //校验token，是否放行 不放行则将响应设置401状态码
        if (token == null || token.isEmpty()) {
            log.info("未登录");
            response.setStatus(401);
            return;
        }
        //调用jwt方法校验token
        try {
            JWT.parseJWT(token);
        } catch (Exception e){
            log.info("token验证失败");
            response.setStatus(401);
            return;
        }
        log.info("令牌通过，放行");
        filterChain.doFilter(request, response);
    }
}
