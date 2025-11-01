package com.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWT {


    @Test
    public void generateJWT() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("username", "xiaozhi");
        dataMap.put("password", "123456");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "5ZSv54ix6YeM576O")   //指定加密算法，密钥（base64编码）
                .addClaims(dataMap)                                                          //添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))              //定义过期时间  6秒之后失效
                .compact();                                                                  //构建jwt
        System.out.println(jwt);
    }


    @Test
    public void parseJWT() {
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsInVzZXJuYW1lIjoieGlhb3poaSIsImV4cCI6MTc1Mzk3NDE2NH0.KK8NjNvysBJrxTluIWlQfuDpG43U1Q3ASj_MApXyKvc";
        Claims claims = Jwts.parser().setSigningKey("5ZSv54ix6YeM576O").parseClaimsJws(jwt)
                .getBody();
        System.out.println(claims);
    }
}
