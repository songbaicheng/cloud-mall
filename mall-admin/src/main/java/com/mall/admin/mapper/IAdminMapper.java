package com.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.admin.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author songbaicheng
 * @description 后台用户表 Mapper 接口
 * @date 2023/6/12 20:55
 */
@Mapper
public interface IAdminMapper extends BaseMapper<Admin> {
}
