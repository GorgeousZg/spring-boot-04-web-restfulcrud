package com.atguigu.springboot04webrestfulcrud.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 登录检查
 * @author Gorgeous
 *
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{
	//目标方法执行之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object user=request.getSession().getAttribute("loginUser");
		if(user==null) {
			//未登陆,返回登录页面
			request.setAttribute("msg", "没有权限请先登陆");
			request.getRequestDispatcher("/index.html").forward(request, response);;
			return false;
		}else {
			//已登陆，放行请求
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
