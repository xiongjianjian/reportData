package com.sapdata.admin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wuhh
 * @info 登陆认证拦截器
 * 创建时间  2018年9月14日
 */
public class UserInterceptor implements HandlerInterceptor {
	/**
	 * 进入 Handler方法之前执行
	 * 用于身份认证、身份授权
	 * 比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	 * @author wuhh
	 * @info preHandle
	 * 创建时间  2018年9月14日
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
		/*//用户是否登录校验
		String url = request.getRequestURI();
		//判断session
		HttpSession session  = request.getSession();
		AdminUser adminUser = (AdminUser) session.getAttribute("currAdminUser");
		//判断url是否是公开 地址（实际使用时将公开 地址配置配置文件中）
		//这里公开地址是登陆提交的地址
		if(url.indexOf("login")>=0){
			//如果进行登陆提交，放行
			return true;
		}
		if(adminUser != null){
			//用户权限校验
			if (hasPrivilegeByUrl(url, adminUser)) {
				// 如果有权限，就放行
				return true;
			} 
		}
		//执行这里表示用户身份需要认证，跳转登陆页面
		request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request, response);
		return false;*/
		return true;
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
	}

	//执行Handler完成执行此方法
	//应用场景：统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	/**
	 * 
	 * @author wuhh
	 * @info hasPrivilegeByUrl
	 * 创建时间  2018年9月17日
	 */
	/*public boolean hasPrivilegeByUrl(String privUrl,AdminUser adminUser){
		WebApplicationContext context=ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext=context.getServletContext();
		// 超级管理有所有的权限
		if (isAdmin(adminUser.getUserName())) {
			return true;
		}
		//去掉后面的参数
		int pos = privUrl.indexOf("?");
		if (pos > -1) {
			privUrl = privUrl.substring(0, pos);
		}
		//截取前面的项目名
		int index=privUrl.indexOf("/");
		index=privUrl.indexOf("/", index+1);
		privUrl = privUrl.substring(index, privUrl.length());
		// 如果本URL不需要控制，则登录用户就可以使用
		Collection<String> powerList =(Collection<String>) servletContext.getAttribute("adminPowerList");
		if (!powerList.contains(privUrl)) {
			return true;
		} else {
			// 普通用户要判断是否含有这个权限
			for (AdminRole adminRole : adminUser.getAdminRoles()) {
				for (AdminPower adminPower : adminRole.getAdminPowers()) {
					if (privUrl.equals(adminPower.getUrl())) {
						return true;
					}
				}
			}
			return false;
		}
	}
	*//**
	 * 判断本用户是否是超级管理员
	 * 
	 * @return
	 *//*
	public boolean isAdmin(String username) {
		return "admin".equals(username);
	}
	
	*//**
	 * 获取字符串/admin/findAll/aaa  /符合最后否数据
	 * @author wuhh
	 * @info getLastStr
	 * 创建时间  2018年10月30日
	 *//*
	public String getLastStr(String url){
		int index=url.lastIndexOf("/");
		url = url.substring(index+1, url.length());
		return url;
	}
	*//**
	 * 获取字符串/admin/findAll/aaa  /符合第二后面的字符
	 * @author wuhh
	 * @info getSecondStr
	 * 创建时间  2018年10月30日
	 *//*
	public String getSecondStr(String url){
		int index=url.indexOf("/");
		int index1=url.indexOf("/", index+1);
		if(index1>0){
			int index2=url.indexOf("/", index1+1);
			if(index2<0){
				url = url.substring(index1+1, url.length());
			}else{
				url = url.substring(index1+1, index2);
			}
		}
		return url;
	}*/
}
