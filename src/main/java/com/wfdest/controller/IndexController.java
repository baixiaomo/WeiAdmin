package com.wfdest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by feiwei on 2017/7/7.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "view/index";
    }
}
