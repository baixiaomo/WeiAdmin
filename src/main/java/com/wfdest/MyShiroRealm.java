package com.wfdest;

import com.wfdest.controller.admin.LoginController;
import com.wfdest.dao.entity.WeiUser;
import com.wfdest.service.UserService;
import com.wfdest.shiro.SysPermission;
import com.wfdest.shiro.SysRole;
import com.wfdest.shiro.UserInfo;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * Created by feiwei on 2017/8/15.
 */
public class MyShiroRealm extends AuthorizingRealm{
    private static final Logger LOGGER = Logger.getLogger(MyShiroRealm.class);
    @Resource
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
         /*
		 * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
		 * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
		 * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了，
		 * 缓存过期之后会再次执行。
		 */
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principalCollection.getPrimaryPrincipal();

        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//		UserInfo userInfo = userInfoService.findByUsername(username)


        //权限单个添加;
        // 或者按下面这样添加
        //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
//		authorizationInfo.addRole("admin");
        //添加权限
//		authorizationInfo.addStringPermission("userInfo:query");



        ///在认证成功之后返回.
        //设置角色信息.
        //支持 Set集合,
        //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
//        List<Role> roleList=user.getRoleList();
//        for (Role role : roleList) {
//            info.addStringPermissions(role.getPermissionsName());
//        }
//		authorizationInfo.setRoles(roles);;
//		authorizationInfo.setStringPermissions(stringPermissions);
        for(SysRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }

        //设置权限信息.
//		authorizationInfo.setStringPermissions(getStringPermissions(userInfo.getRoleList()));

        return authorizationInfo;
    }

    /**
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        LOGGER.info("进入Shiro认证...");
        String username = (String) token.getPrincipal();
        String credentials  = (String) token.getCredentials();
        LOGGER.info("username = "+username+"--credentials = "+credentials);
        com.wfdest.dao.entity.UserInfo userInfo = userService.getUserInfoByExample(username);
        if(userInfo == null){
            LOGGER.info("用户为空");
            return null;
        }
        //明文认证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userInfo,userInfo.getPassword(),getName());
        //SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,token.getCredentials(),getName());
        return simpleAuthenticationInfo;
    }
}
