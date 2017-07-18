package com.wfdest.dao.mapper;

import com.wfdest.dao.entity.WeiDictionary;

public interface WeiDictionaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeiDictionary record);

    int insertSelective(WeiDictionary record);

    WeiDictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeiDictionary record);

    int updateByPrimaryKey(WeiDictionary record);
}