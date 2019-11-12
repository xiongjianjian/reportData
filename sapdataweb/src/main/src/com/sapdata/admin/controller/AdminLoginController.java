package com.sapdata.admin.controller;

import com.sapdata.admin.bean.AdminUser;
import com.sapdata.admin.mysqlservice.AdminUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * @Author: wuhonghui
 * @Description: 登录操作
 * @Date: 2019/11/12 9:27
 * @Modified: wuhonghui
 **/
@Controller
public class AdminLoginController {
	@Autowired
	private AdminUserService adminUserService;
	/**
	 * @Author: wuhonghui
	 * @Description: 登录页面
	 * @Date: 2019/11/12 9:27
	 * @Modified: wuhonghui
	 **/
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
	 * @Author: wuhonghui
	 * @Description: 登录校验
	 * @Date: 2019/11/12 9:27
	 * @Modified: wuhonghui
	 **/
	@RequestMapping("/loginCheck")
	public String loginCheck(HttpServletRequest request, String userCode,String password,Integer roleCode) throws Exception {
		HttpSession session  = request.getSession();
		password = DigestUtils.md5Hex(password);
		if(StringUtils.isNotBlank(userCode) && StringUtils.isNotBlank(password)){
			AdminUser currAdminUser=new AdminUser();
			if(roleCode==2){//销售员登录
				currAdminUser=adminUserService.checkUserBysSale(userCode,password);
				if(currAdminUser==null){
					return "redirect:/login?loginError=1";
				}
				currAdminUser.setLoginMode(2);//销售员
			}else{//用户编号登录
				currAdminUser=adminUserService.checkUserByCustom(userCode,password);
				if(currAdminUser==null){
					return "redirect:/login?loginError=1";
				}
				if(currAdminUser.getRoleCode()==1){
					currAdminUser.setLoginMode(3);//管理员
				}else{
					currAdminUser.setLoginMode(1);//普通商户
				}
			}
			session.setAttribute("currAdminUser", currAdminUser);
			return "redirect:/index";
		}else{
			return "redirect:/login?loginError=1";
		}
	}
	/**
	 * @Author: wuhonghui
	 * @Description: 注销
	 * @Date: 2019/11/12 9:27
	 * @Modified: wuhonghui
	 **/
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session  = request.getSession();
		session.setAttribute("currAdminUser", null);
		return "redirect:/login";

	}
}