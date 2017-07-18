package com.wfdest.controller.world;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by feiwei on 2017/7/18.
 */
@Controller
public class IndexController {
    @GetMapping({"","/world"})
    public String world(){
        return "/world/world";
    }
    @GetMapping("/profile")
    public String profile(HttpSession session){
        Enumeration<String> e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String s = e.nextElement();
            System.out.println(s + " == " + session.getAttribute(s));
        }
        return "world/profile";
    }
}
