package com.wfdest.dao.mapper;

import com.wfdest.dao.entity.SysRolePermission;

public interface SysRolePermissionMapper {
    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);
}