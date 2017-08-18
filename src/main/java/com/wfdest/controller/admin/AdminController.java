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


    /**
     * 工作台
     * @return
     */
    @RequestMapping("/admin")
    public String workbench(){
        return "admin/workbench";
    }

    /**
     * 文件管理
     * @return
     */
    @RequestMapping("filemanager")
    public String filemanager(){
        return "admin/filemanager";
    }
    /**
     * 字典管理
     * @return
     */
    @RequestMapping("dictmanager")
    public String dictmanager(){
        return "admin/dictmanager";
    }
}
