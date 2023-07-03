package com.mall.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.mall.service.IRedisService;
import com.mall.service.impl.IRedisServiceImpl;

/**
 * @ClassName RedisConfig
 * @Description Redis 配置
 * @Author songbaicheng
 * @Date 2023/6/20 10:07
 */
public class BaseRedisConfig {

    /**
     * 使用Lettuce作为Redis客户端
     *
     * @return 返回一个 Lettuce 连接工厂
     */
    @Bean
    LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    /**
     * RedisTemplate 自定义配置
     * @param redisConnectionFactory Redis 连接工厂
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisSerializer<Object> serializer = redisSerializer();
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        // 设置Redis连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 设置用于序列化Redis键的序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置用于序列化Redis值的序列化器
        redisTemplate.setValueSerializer(serializer);
        // 设置用于序列化Redis哈希表键的序列化器
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // 设置用于序列化Redis哈希表值的序列化器
        redisTemplate.setHashValueSerializer(serializer);
        // 确保RedisTemplate的属性已经设置完毕，并进行必要的初始化。
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    /**
     * Redis 自定义序列化方法
     * @return 自定义序列化器
     */
    public RedisSerializer<Object> redisSerializer() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 必须设置，否则无法将JSON转化为对象，会转化成Map类型
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);

        return new Jackson2JsonRedisSerializer<>(objectMapper, Object.class);
    }

    /**
     * redis 工具类
     */
    @Bean
    public IRedisService redisService() {
        return new IRedisServiceImpl();
    }

}
