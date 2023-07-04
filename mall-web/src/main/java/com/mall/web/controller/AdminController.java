package com.mall.web.controller;

import com.mall.entity.Admin;
import com.mall.web.service.IAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author songbaicheng
 * @description 后台用户表 前端控制器
 * @date 2023/6/12 20:59
 */
@Slf4j
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final IAdminService iAdminService;

    @GetMapping("/test")
    public String test() {
        log.info("test");
        return "test";
    }

    @PostMapping(value = "/{id}")
    public Admin getById(@PathVariable("id") String id) {
        return iAdminService.getById(id);
    }

}
