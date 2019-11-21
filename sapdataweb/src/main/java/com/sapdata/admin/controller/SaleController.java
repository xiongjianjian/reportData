package com.sapdata.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wuhonghui
 * @Description:
 * @Date: 2019/11/12 8:58
 * @Modified: wuhonghui
 **/
@Controller
@RequestMapping("/saleExport")
public class SaleController {
    /**
     * @Author: wuhonghui
     * @Description: 主界面
     * @Date: 2019/11/11 14:12
     * @Modified: wuhonghui
     **/
    @RequestMapping("/findAll")
    public ModelAndView index(HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("saleExport/findAll");
        return modelAndView;

    }
}
