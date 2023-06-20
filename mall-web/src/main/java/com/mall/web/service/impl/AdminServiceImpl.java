package com.mall.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.web.entity.Admin;
import com.mall.web.mapper.IAdminMapper;
import com.mall.web.service.IAdminService;
import org.springframework.stereotype.Service;

/**
 * @author songbaicheng
 * @description 后台用户表 服务实现类
 * @date 2023/6/12 20:57
 */
@Service
public class AdminServiceImpl extends ServiceImpl<IAdminMapper, Admin> implements IAdminService {
}
