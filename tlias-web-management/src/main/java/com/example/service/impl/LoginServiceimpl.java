package com.example.service.impl;

import com.example.mapper.LoginMapper;
import com.example.pojo.Emp;
import com.example.pojo.Logininfo;
import com.example.service.LoginService;
import com.example.utils.JWT;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Logininfo login(Emp emp) {
        Emp e=loginMapper.select(emp);
        Logininfo logininfo=new Logininfo();
        if(e!=null){
           logininfo.setId(e.getId());
           logininfo.setUsername(e.getUsername());
           logininfo.setName(e.getName());
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",e.getId());
            claims.put("username",e.getUsername());
           logininfo.setToken(JWT.generateJWT(claims));
            return logininfo;
        }
        return null;
    }
}
