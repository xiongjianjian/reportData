package com.sapdata.admin.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * @Author: wuhonghui
 * @Description: 登录进来的首界面
 * @Date: 2019/11/11 14:12
 * @Modified: wuhonghui
 **/
@Controller
public class AdminIndexController {
	/**
	 * @Author: wuhonghui
	 * @Description: 主界面
	 * @Date: 2019/11/11 14:12
	 * @Modified: wuhonghui
	 **/
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index/index");
		return modelAndView;

	}
	/**
	 * @Author: wuhonghui
	 * @Description: 页面底部
	 * @Date: 2019/11/11 14:13
	 * @Modified: wuhonghui
	 **/
	@RequestMapping("/bottom")
	public ModelAndView bottom(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index/bottom");
		return modelAndView;

	}
	/**
	 * @Author: wuhonghui
	 * @Description: 页面左边菜单栏
	 * @Date: 2019/11/11 14:13
	 * @Modified: wuhonghui
	 **/
	@RequestMapping("/menu")
	public ModelAndView menu(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index/menu");
		return modelAndView;

	}
	/**
	 * @Author: wuhonghui
	 * @Description: 页面头部
	 * @Date: 2019/11/11 14:13
	 * @Modified: wuhonghui
	 **/
	@RequestMapping("/top")
	public ModelAndView top(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index/top");
		return modelAndView;

	}
}
