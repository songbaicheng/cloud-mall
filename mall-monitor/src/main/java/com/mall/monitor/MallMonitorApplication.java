package com.mall.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName MallMonitorApplication
 * @Description 商城监视器启动类
 * @Author songbaicheng
 * @Date 2023/6/15 14:29
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class MallMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallMonitorApplication.class, args);
    }
}
