package com.mall.admin.controller;

import com.mall.admin.entity.Admin;
import com.mall.admin.service.IAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songbaicheng
 * @description 后台用户表 前端控制器
 * @date 2023/6/12 20:59
 */
@RestController("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final IAdminService iAdminService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Admin> getById(@PathVariable("id") String id) {

        if (ObjectUtils.isEmpty(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(iAdminService.getById(id), HttpStatus.OK);
    }
}
