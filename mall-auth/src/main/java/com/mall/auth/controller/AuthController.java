package com.mall.auth.controller;

import com.mall.auth.feign.IAdminService;
import com.mall.auth.utils.JwtUtils;
import com.mall.entity.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author songbaicheng
 * @description 认证请求接口
 * @date 2023/6/17 11:34
 */
@RestController
@RequestMapping("/oauth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtils jwtUtils;
    private final IAdminService adminService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestParam String id) {

        System.out.println(adminService.test());
        Admin admin = adminService.getById(id);
        String token = jwtUtils.generateToken(admin.getUsername());

        return ResponseEntity.ok(token);
    }
}
