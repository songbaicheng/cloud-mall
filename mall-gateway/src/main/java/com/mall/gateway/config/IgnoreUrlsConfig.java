package com.mall.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @ClassName IgnoreUrlsConfig
 * @Description 网关白名单配置
 * @Author songbaicheng
 * @Date 2023/6/19 17:15
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix="secure.ignore")
public class IgnoreUrlsConfig {

    private List<String> urls;
}
