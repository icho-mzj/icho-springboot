/*
package com.icho.common;

import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;

*/
/**
 * @Author: icho
 * @Date: 2022/4/17 1:55
 * @Describe: //token生成器
 *//*

@Component
public class TokenManager {

    //token有效时长
    private long tokenEcpiration = 24*60*60*1000;
    //编码秘钥
    private String tokenSignKey = "123456";

    //1 使用jwt根据用户名生成token
    public String createToken(String username) {
        //实例化
        JwtBuilder jwtBuilder = Jwts.builder();
        //jwt的唯一标识
        jwtBuilder.setId(UUID.randomUUID().toString());
        //生成的时间
        jwtBuilder.setIssuedAt(new Date());
        //主题,就行邮件的主体一样
        jwtBuilder.setSubject(username);
        //相当于playload,只是这个会将map转成json,而那个会是一个字符串
        jwtBuilder.setClaims(new HashMap<>(1));
        //加密算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //设置签名
        jwtBuilder.signWith(signatureAlgorithm,tokenSignKey);
        //设置过期时间,其中的时间戳要大于生成时间
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + tokenEcpiration));
        //压缩生成token
        return jwtBuilder.compact();
    }

    //2 根据token字符串得到用户信息
    public String getUserInfoFromToken(String token) {
        JwtParser parser = Jwts.parser();
        //设置解密盐
        parser.setSigningKey(tokenSignKey);
        //设置需要解密的token,并获取DefaultJwtParser对象
        Claims claims = parser.parseClaimsJws(token).getBody();
        //获取token中的主体信息
        String subject = claims.getSubject();
        return subject;
    }

    //3 删除token
    public void removeToken(String token) { }
}
*/
