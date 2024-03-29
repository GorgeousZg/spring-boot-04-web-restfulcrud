package com.atguigu.springboot04webrestfulcrud.component;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

/**
 * 可以在连接上携带区域信息
 * @author Gorgeous
 *
 */
public class MyLocaleResolver implements LocaleResolver{

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
 		String l= request.getParameter("l");
		Locale locale=Locale.getDefault();
		if(!StringUtils.isEmpty(l)) {
			String[] split= l.split("_");
			new Locale(split[0],split[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// TODO Auto-generated method stub
		
	}

}
