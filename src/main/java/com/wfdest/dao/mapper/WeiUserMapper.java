package com.wfdest.dao.mapper;

import com.wfdest.dao.entity.WeiUser;

public interface WeiUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeiUser record);

    int insertSelective(WeiUser record);

    WeiUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeiUser record);

    int updateByPrimaryKey(WeiUser record);
}