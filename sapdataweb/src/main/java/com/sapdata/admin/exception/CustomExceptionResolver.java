package com.sapdata.admin.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 * @author wuhh
 * @info CustomExceptionResolver.java
 * 创建时间  2018年10月8日
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
	private final static Logger logger = LoggerFactory.getLogger(CustomExceptionResolver.class);

	/**
	 * 系统 抛出的异常
	 * @author wuhh
	 * @info resolveException
	 * 创建时间  2018年10月8日
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
		String method=request.getRequestURI();
		logger.info(method+ex.getMessage());
		//错误信息
		String message = ex.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		//将错误信息传到页面
		modelAndView.addObject("loginError", message);
		//指向错误页面
		modelAndView.setViewName("/error");
		return modelAndView;
	}

}
