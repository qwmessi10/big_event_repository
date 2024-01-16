package com.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");

        String token = JWT.create()
                .withClaim("user", claims)    // 添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))  // 添加过期时间
                .sign(Algorithm.HMAC256("itheima"));// 置顶算法,配置密钥

        System.out.println(token);
    }

    @Test
    public void testPass() {
        // 定义字符串,模拟用户传递过来的token
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDQzODk2MTMsI" +
                "nVzZXIiOnsiaWQiOjEsInVzZXJuYW1lIjoi5byg5LiJIn19.Tp3nOwwC2o_m07PuAyP--ajy720maFoek-Ow1exxDPo";

        JWTVerifier jwtVerifer = JWT.require(Algorithm.HMAC256("itheima")).build();

        DecodedJWT decodeJwt = jwtVerifer.verify(token);
        Map<String, Claim> claims = decodeJwt.getClaims();
        System.out.println(claims.get("user"));
    }
}
