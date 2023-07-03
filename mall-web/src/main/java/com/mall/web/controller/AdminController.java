package com.mall.web.controller;

import com.mall.entity.Admin;
import com.mall.web.service.IAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Admin> getById(@PathVariable("id") String id) {

        if (ObjectUtils.isEmpty(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(iAdminService.getById(id), HttpStatus.OK);
    }

}
