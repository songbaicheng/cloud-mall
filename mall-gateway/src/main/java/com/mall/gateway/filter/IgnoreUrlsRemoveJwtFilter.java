package com.mall.gateway.filter;

import com.mall.gateway.config.IgnoreUrlsConfig;
import content.AuthConstantEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

/**
 * @author songbaicheng
 * @description 访问白名单路径时移除JWT请求头
 * @date 2023/6/19 20:40
 */
@Component
@RequiredArgsConstructor
public class IgnoreUrlsRemoveJwtFilter implements WebFilter {

    private final IgnoreUrlsConfig ignoreUrlsConfig;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        URI uri = request.getURI();
        PathMatcher pathMatcher = new AntPathMatcher();

        //白名单路径移除JWT请求头
        List<String> ignoreUrls = ignoreUrlsConfig.getUrls();
        for (String ignoreUrl : ignoreUrls) {
            if (pathMatcher.match(ignoreUrl, uri.getPath())) {
                request = exchange.getRequest().mutate().header(AuthConstantEnum.JWT_TOKEN_HEADER.getValue(), "").build();
                exchange = exchange.mutate().request(request).build();
                return chain.filter(exchange);
            }
        }

        return chain.filter(exchange);
    }
}
