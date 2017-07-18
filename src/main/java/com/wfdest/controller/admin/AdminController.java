package com.wfdest.controller.admin;

import com.wfdest.constant.ErrorMessage;
import com.wfdest.dao.entity.WeiUser;
import com.wfdest.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by feiwei on 2017/7/7.
 */
@Controller
@SessionAttributes("userState")
public class AdminController {
    private static final Logger LOGGER = Logger.getLogger(AdminController.class);
    @Resource
    private UserService userService;
    @RequestMapping("/admin")
    public String start(String email, String password, ModelMap map,HttpSession session){
        WeiUser user = new WeiUser();
        LOGGER.info(email+"---"+password);
        user.setPassword(password);
        user.setEmail(email);
        //直接访问web
        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password)){
            map.addAttribute("error_message", ErrorMessage.LOGGING_WITH_ERROR_PASSWORD);
            return "/admin/login";
        }
        if(!userService.isAdmin(user)){
            map.addAttribute("error_message", ErrorMessage.LOGGING_WITH_ERROR_PASSWORD);
            return "/admin/login";
        }
        //可以通过管理员身份登录
        user.setState(1);//管理员登陆
        map.addAttribute("userState",1);

        Enumeration<String> e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String s = e.nextElement();
            LOGGER.info(s + " == " + session.getAttribute(s));
        }
        map.addAttribute("user",user);
        return "admin/admin";
    }
    @GetMapping("/login")
    public String login(HttpSession session){
        Enumeration<String> e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String s = e.nextElement();
            LOGGER.info(s + " == " + session.getAttribute(s));
        }
        return "admin/login";
    }
    @GetMapping("register")
    public String register(){
        return "admin/register";
    }

}
