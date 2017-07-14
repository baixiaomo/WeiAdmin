package com.wfdest.controller;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.wfdest.dao.entity.WeiUser;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by feiwei on 2017/7/7.
 */
@Controller
public class IndexController {
    private static final Logger LOGGER = Logger.getLogger(IndexController.class);

    @RequestMapping("/index")
    public String index(){
        return "view/index";
    }
    @RequestMapping("/admin")
    public String start(String email,String password){
        WeiUser user = new WeiUser();
        LOGGER.info(email+"---"+password);
        user.setUsername("卫子鱼");
        if(null != email && email.length()>0 && null != password && password.length()>0){
            user.setEmail(email);
            user.setPassword(password);
            user.setState(1);

        }else{
            user.setState(0);
        }
        return "admin/admin";
    }
    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }
    @GetMapping("register")
    public String register(){
        return "admin/register";
    }
}
