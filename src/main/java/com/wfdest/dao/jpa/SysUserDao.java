package com.wfdest.dao.jpa;

import com.wfdest.shiro.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by feiwei on 2017/8/16.
 */
public interface SysUserDao extends CrudRepository<UserInfo,Long>{
    UserInfo findByUsername(String username);
}
