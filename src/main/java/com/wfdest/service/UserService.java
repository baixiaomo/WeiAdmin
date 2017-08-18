package com.wfdest.service;

import com.wfdest.dao.WeiUserDao;
import com.wfdest.dao.entity.UserInfoExample;
import com.wfdest.dao.entity.WeiUser;
import com.wfdest.dao.jpa.SysUserDao;
import com.wfdest.dao.mapper.UserInfoMapper;
import com.wfdest.dao.mapper.WeiUserMapper;
import com.wfdest.shiro.UserInfo;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private UserInfoMapper userInfoMapper;

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

    /**
     * 根据姓名查询用户
     * @param name
     * @return
     */
    public WeiUser getUserByName(String name){
        return userDao.getUserByName(name);
    }

    /**
     * 根据姓名查询用户（Shiro）
     * @param username
     * @return
     */
    public UserInfo findByUsername(String username){
        return sysUserDao.findByUsername(username);
    }
    public com.wfdest.dao.entity.UserInfo getUserInfoByExample(String username){
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<com.wfdest.dao.entity.UserInfo> list = userInfoMapper.selectByExample(example);
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
