package com.mall.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author songbaicheng
 * @description SpringSecurity配置
 * @date 2023/6/17 11:12
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * 定义登录用户
     *
     * @return
     */
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails adminUser = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails ownUser = User.withUsername("songbaicheng")
                .password(passwordEncoder().encode("songbaicheng"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(adminUser, ownUser);
    }

    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {

        http.formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/oauth/hello", "/oauth/token").permitAll()
                        .anyRequest().authenticated());

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
