package com.mall.auth.utils;

import com.mall.auth.config.JwtConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @ClassName JwtUtils
 * @Description JWT工具类
 * @Author songbaicheng
 * @Date 2023/7/3 10:40
 */
@Component
@RequiredArgsConstructor
public class JwtUtils {

    private final JwtConfig jwtConfig;

    /**
     * 定义系统标识头常量
     */
    private static final String HEADER_SYSTEM_KEY = "JWT";

    /**
     * 根据用户ID生成JWT
     *
     * @param username 用户名
     * @return JWT
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setExpiration(generateExpirationDate())
                .setSubject(username)
                .signWith(Keys.hmacShaKeyFor(jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8)))
                .compact();
    }

    /**
     * 生成token的过期时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + jwtConfig.getExpiration() * 1000);
    }
}
