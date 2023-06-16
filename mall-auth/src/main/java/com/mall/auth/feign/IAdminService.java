package com.mall.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName IAdminController
 * @Description 调用
 * @Author songbaicheng
 * @Date 2023/6/16 15:39
 */
@FeignClient("mall-admin")
public interface IAdminService {

    @GetMapping("/admin/test")
    String test();
}
