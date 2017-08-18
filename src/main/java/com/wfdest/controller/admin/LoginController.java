package com.wfdest.controller.admin;

import com.wfdest.dao.entity.WeiUser;
import com.wfdest.service.UserService;
import com.wfdest.shiro.UserInfo;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by feiwei on 2017/8/15.
 */
@Controller
public class LoginController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    @Resource
    private UserService userService;
    @GetMapping("/login")
    public String login(HttpSession session){
        WeiUser weiUser = userService.getUserByName("weifei");
       // UserInfo userInfo = userService.findByUsername("weifei");
        com.wfdest.dao.entity.UserInfo user = userService.getUserInfoByExample("weifei");
        if (weiUser == null){
            LOGGER.info("没有查询到用户");
        }else{
            LOGGER.info(weiUser.getPassword()+","+weiUser.getUsername());
        }
        /*if (userInfo == null){
            LOGGER.info("没有查询到用户");
        }else{
            LOGGER.info(userInfo.getPassword()+","+userInfo.getUsername());
        }*/
        if (user == null){
            LOGGER.info("没有查询到用户");
        }else{
            LOGGER.info(user.getPassword()+","+user.getUsername());
        }
        return "login";
    }

    /**
     * 处理登陆失败
     * @param request
     * @param map
     * @return
     */
    @PostMapping("/login")
    public String login(HttpServletRequest request, ModelMap map) throws Exception{
        LOGGER.info("LoginController.login[post]...");
        String exception = (String) request.getAttribute("shiroLoginFailure");
        LOGGER.info("--->exception="+exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.addAttribute("error_message",msg);
        return "login";
    }

}
