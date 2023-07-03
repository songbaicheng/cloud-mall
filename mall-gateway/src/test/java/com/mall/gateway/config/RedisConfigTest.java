package com.mall.gateway.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mall.service.IRedisService;

/**
 * @author songbaicheng
 * @description Redis 配置测试
 * @date 2023/6/24 18:01
 */
@SpringBootTest
class RedisConfigTest {

    @Autowired
    private IRedisService redisService;

    @Test
    void Test() {
        redisService.set("test", "newValue is me");
        System.out.println("==========================================" + redisService.get("test"));

        redisService.hSet("hashTest", "one", "one value");
        System.out.println("==========================================" + redisService.hGet("hashTest", "one"));
    }
}