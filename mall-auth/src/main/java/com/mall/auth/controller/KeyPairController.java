package com.mall.auth.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @ClassName KeyPairController
 * @Description 获取RSA公钥接口
 * @Author songbaicheng
 * @Date 2023/6/19 16:36
 */
@RestController
@RequestMapping("/rsa")
@RequiredArgsConstructor
public class KeyPairController {

    private final KeyPair keyPair;

    @GetMapping("/publicKey")
    public Map<String, Object> getJwtPublicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }
}
