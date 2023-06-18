package com.mall.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author songbaicheng
 * @description SpringSecurity配置
 * @date 2023/6/17 11:12
 */
@Configuration
public class WebSecurityConfig {

    /**
     * 密码加密器
     * @return 指定的密码加密器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
