package com.wfdest.dao;

import com.wfdest.dao.entity.WeiUser;
import org.springframework.stereotype.Component;

/**
 * Created by feiwei on 2017/7/14.
 */

public interface WeiUserDao {
    WeiUser getUserByEmailAndPassword(WeiUser user);
    WeiUser getUserByName(String name);
}
