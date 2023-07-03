package com.mall.content;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author songbaicheng
 * @description 权限相关常量定义
 * @date 2023/6/19 21:06
 */
@Getter
@AllArgsConstructor
public enum AuthConstantEnum {

    /**
     * JWT存储权限前缀
     */
    AUTHORITY_PREFIX("ROLE_"),

    /**
     * JWT存储权限属性
     */
    AUTHORITY_CLAIM_NAME("authorities"),

    /**
     * 后台管理client_id
     */
    ADMIN_CLIENT_ID("admin-app"),

    /**
     * 前台商城client_id
     */
    PORTAL_CLIENT_ID("portal-app"),

    /**
     * 后台管理接口路径匹配
     */
    ADMIN_URL_PATTERN("/mall-admin/**"),

    /**
     * Redis缓存权限规则key
     */
    RESOURCE_ROLES_MAP_KEY("auth:resourceRolesMap"),

    /**
     * 认证信息Http请求头
     */
    JWT_TOKEN_HEADER("Authorization"),

    /**
     * JWT令牌前缀
     */
    JWT_TOKEN_PREFIX("Bearer "),

    /**
     * 用户信息Http请求头
     */
    USER_TOKEN_HEADER("user");

    private final String value;
}
