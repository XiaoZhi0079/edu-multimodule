package com.example.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JWT {
    private static final String SECRET="5ZSv54ix6YeM576O";
    private static final long EXPIRATION=86400000;
    public static String generateJWT(Map<String, Object> claims){

        String jwt= Jwts.builder().signWith(SignatureAlgorithm.HS256,SECRET)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION))
                .compact();
        return jwt;
    }
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser().setSigningKey("5ZSv54ix6YeM576O").parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}

