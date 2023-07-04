package com.mall.auth.feign;

import com.mall.entity.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName IAdminController
 * @Description 调用
 * @Author songbaicheng
 * @Date 2023/6/16 15:39
 */
@FeignClient("mall-web")
public interface IAdminService {

    @GetMapping("/admin/test")
    String test();

    @PostMapping(value = "/admin/{id}")
    Admin getById(@PathVariable("id") String id);
}
