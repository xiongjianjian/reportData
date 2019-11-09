package com.sapdata.admin.controller;

import com.sapdata.admin.bean.AdminUser;
import com.sapdata.admin.mysqlservice.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: wuhonghui
 * @Description:
 * @Date: 2019/11/9 9:41
 * @Modified: wuhonghui
 **/
@Controller
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("/findByUserCode")
    @ResponseBody
    public AdminUser findByUserCode(){
        AdminUser adminUser=adminUserService.selectByPrimaryKey(1L);
        return adminUser;
    }
}
