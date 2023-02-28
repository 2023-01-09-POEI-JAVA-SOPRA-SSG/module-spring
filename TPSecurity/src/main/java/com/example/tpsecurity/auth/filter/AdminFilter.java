package com.example.tpsecurity.auth.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.tpsecurity.auth.SecurityUtil;

@Component
@Order(1)
public class AdminFilter implements Filter {

	@Autowired
	SecurityUtil securityUtil;
	
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String token = request.getHeader("AUTHORIZATION");
		
		if (  !securityUtil.isValidToken(token) || !securityUtil.canAcces(token, "ADMIN") ) {
			throw new ServletException();
		}
		
		chain.doFilter(request, response);
	}
	
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("==============INIT=================");
	}

	@Override
	public void destroy() {
		System.out.println("==============DESTROY=================");
	}



}
