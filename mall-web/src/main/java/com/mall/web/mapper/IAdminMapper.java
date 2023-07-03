package com.mall.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.mall.entity.Admin;

/**
 * @author songbaicheng
 * @description 后台用户表 Mapper 接口
 * @date 2023/6/12 20:55
 */
@Mapper
public interface IAdminMapper extends BaseMapper<Admin> {
}
