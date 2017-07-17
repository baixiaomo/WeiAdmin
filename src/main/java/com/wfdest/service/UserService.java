package com.wfdest.service;

import com.wfdest.dao.WeiUserDao;
import com.wfdest.dao.entity.WeiUser;
import com.wfdest.dao.mapper.WeiUserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by feiwei on 2017/7/14.
 */
@Service
public class UserService {
    private static Logger logger = Logger.getLogger(UserService.class);
    @Resource
    private WeiUserMapper userMapper;
    @Resource
    private WeiUserDao userDao;
    public int updateUser(WeiUser user){
        return userMapper.updateByPrimaryKeySelective(user);
    }
    public boolean isAdmin(WeiUser user){
        WeiUser weiUser = userDao.getUserByEmailAndPassword(user);
        if (weiUser != null && "ADMIN".equals(weiUser.getRole())){
            logger.info("管理员校验");
            return true;
        }
        return false;
    }

}
