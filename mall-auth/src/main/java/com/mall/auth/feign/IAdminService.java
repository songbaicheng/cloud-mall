package com.mall.auth.feign;

import com.mall.entity.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping(value = "/admin/{id}")
    ResponseEntity<Admin> getById(@PathVariable("id") String id);
}
