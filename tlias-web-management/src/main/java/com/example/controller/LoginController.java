package com.example.controller;


import com.example.pojo.Emp;
import com.example.pojo.Logininfo;
import com.example.pojo.Result;
import com.example.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("请求登录...");
        Logininfo info=loginService.login(emp);
        if(info!=null){
            log.info("登录成功..."+ info);
        return Result.success(info);
    }
        else return Result.error("用户名或密码错误");
    }

}
