package com.sapdata.admin.controller;

import com.github.pagehelper.PageInfo;
import com.sapdata.admin.bean.AdminUser;
import com.sapdata.admin.bean.AdminUserVo;
import com.sapdata.admin.mysqlservice.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: wuhonghui
 * @Description:用户列表
 * @Date: 2019/11/9 9:41
 * @Modified: wuhonghui
 **/
@Controller
@RequestMapping("/user")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    //页数
    private final int pageSize=10;

    /**
     * @Author: wuhonghui
     * @Description: 获取用户
     * @Date: 2019/11/12 9:26
     * @Modified: wuhonghui
     **/
    @RequestMapping("/findAll")
    @ResponseBody
    public ModelAndView findAll(Integer queryPageNo,Integer pageSize){
        AdminUserVo adminUserVo=new AdminUserVo();
        adminUserVo.setPageNo(queryPageNo);//第几页
        adminUserVo.setPageSize(pageSize);//每页显示条数
        List<AdminUser> userList=adminUserService.findAll(adminUserVo);
        Long total=adminUserService.countAll(adminUserVo);//总条数
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/findAll");
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("total",total);
        return modelAndView;
    }
    /**
     * @Author: wuhonghui
     * @Description: 跳转修改密码页面
     * @Date: 2019/11/12 13:46
     * @Modified: wuhonghui
     **/
    @RequestMapping("/toUpdatePass")
    @ResponseBody
    public ModelAndView toUpdatePass(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/updatePass");
        return modelAndView;
    }
    /**
     * @Author: wuhonghui
     * @Description: 跳转添加用户页面
     * @Date: 2019/11/12 13:46
     * @Modified: wuhonghui
     **/
    @RequestMapping("/userAdd")
    @ResponseBody
    public ModelAndView userAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/userAdd");
        return modelAndView;
    }
}
