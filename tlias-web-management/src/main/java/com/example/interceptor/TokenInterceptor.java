package com.example.interceptor;


import com.example.utils.CurrentHolder;
import com.example.utils.JWT;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


//注释掉Component注解，则该拦截器不生效
//@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    //在目标资源运行前执行 返回true则执行，返回false拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        //获取路径
        String path = request.getRequestURI();
        if (path.contains("login")) {
            log.info("登录请求,放行");
            return true;
        }
        //获取token
        String token = request.getHeader("token");
        //校验token是否为null或空字符串
        if (token == null || token.isEmpty()) {
            log.info("token为空");
            response.setStatus(401);
            return false;
        }
        //检验token是否正常
        try{
            JWT.parseJWT(token);
            Claims claims = JWT.parseJWT(token);
            //定义empid，将claims中的id传进empid，再传入线程
            Integer empid;
            empid = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empid);
            log.info("当前用户id为：{}",empid);
        } catch (Exception e) {
            log.info("token验证失败");
            response.setStatus(401);
            return false;
        }
        log.info("令牌通过，放行");
        return true;

    }

    //在目标资源运行后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");

    }
    //在目标资源运行完成后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");
        CurrentHolder.remove();
        log.info("线程信息{}",CurrentHolder.getCurrentId());
    }


}
