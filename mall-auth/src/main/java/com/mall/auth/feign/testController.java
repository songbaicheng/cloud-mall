package com.mall.auth.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName testController
 * @Description TODO
 * @Author songbaicheng
 * @Date 2023/6/16 15:55
 */
@RestController
public class testController {

    @Autowired
    private IAdminService iAdminService;

    @GetMapping("/test")
    public String test() {
        return iAdminService.test();
    }
}
