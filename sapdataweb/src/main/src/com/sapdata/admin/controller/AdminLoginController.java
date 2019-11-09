package com.sapdata.admin.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminLoginController {
	/**
	 * @author 登录页面
	 * @info login
	 * 创建时间  2018年9月14日
	 */
	@RequestMapping("/login")
	public ModelAndView login(String loginError) throws Exception {
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		if(StringUtils.isNotBlank(loginError)){
			if(loginError.equals("1")){
				modelAndView.addObject("loginError", "用户名和密码不能为空");
			}else if(loginError.equals("2")){
				modelAndView.addObject("loginError", "用户名不存在");
			}
		}
		modelAndView.setViewName("user/login");
		return modelAndView;

	}
	/**
	 * @author 登录校验
	 * @info loginCheck
	 * 创建时间  2018年9月14日
	 */
	@RequestMapping("/loginCheck")
	public String loginCheck(HttpServletRequest request, String userName, String password) throws Exception {
		if(StringUtils.isBlank(userName)|| StringUtils.isBlank(password)){
			return "redirect:/login?loginError=1";
		}
		return "redirect:/index/index";

	}
	/**
	 * @author 注销
	 * @info logout
	 * 创建时间  2018年9月14日
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session  = request.getSession();
		session.setAttribute("currAdminUser", null);
		return "redirect:/login";

	}
}