package com.mall.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.admin.entity.Admin;
import com.mall.admin.mapper.IAdminMapper;
import com.mall.admin.service.IAdminService;
import org.springframework.stereotype.Service;

/**
 * @author songbaicheng
 * @description 后台用户表 服务实现类
 * @date 2023/6/12 20:57
 */
@Service
public class AdminServiceImpl extends ServiceImpl<IAdminMapper, Admin> implements IAdminService {
}
