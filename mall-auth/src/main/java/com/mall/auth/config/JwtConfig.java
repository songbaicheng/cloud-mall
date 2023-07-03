package com.mall.auth.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName JwtConfig
 * @Description JWT 参数配置类
 * @Author songbaicheng
 * @Date 2023/7/3 10:42
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    /**
     * 密钥
     */
    private String secret;

    /**
     * 过期时间
     */
    private long expiration;
}
