package com.mall.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songbaicheng
 * @description <TODO description class>
 * @date 2023/6/10 12:53
 */
@RestController
public class testController {

    @Value("${people.name}")
    private String name;

    @Value("${people.age}")
    private String age;

    @GetMapping("/hello")
    public String hello() {
        return name + age;
    }
}
