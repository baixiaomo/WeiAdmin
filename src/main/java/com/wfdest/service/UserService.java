package com.wfdest.service;

import com.wfdest.dao.entity.WeiUser;
import com.wfdest.dao.mapper.WeiUserMapper;
import org.springframework.stereotype.Service;

/**
 * Created by feiwei on 2017/7/14.
 */
@Service
public class UserService {
    private WeiUserMapper userMapper;
    public int updateUser(WeiUser user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

}
