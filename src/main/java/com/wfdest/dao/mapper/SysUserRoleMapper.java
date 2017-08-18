package com.wfdest.dao.mapper;

import com.wfdest.dao.entity.SysUserRole;

public interface SysUserRoleMapper {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}