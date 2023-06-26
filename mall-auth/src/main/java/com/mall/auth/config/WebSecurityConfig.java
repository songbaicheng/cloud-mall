package com.mall.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author songbaicheng
 * @description SpringSecurity配置
 * @date 2023/6/17 11:12
 */
@Configuration
@EnableWebFluxSecurity
//@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * 授权请求规则
     *
     * @param http
     * @return
     */
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        http.authorizeExchange((authorize) -> authorize
                .pathMatchers("/rsa/publicKey", "/oauth/token").permitAll()
                .anyExchange().denyAll()
        );

        return http.build();
    }

    /**
     * 密码加密器
     *
     * @return 指定的密码加密器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
