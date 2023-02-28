package com.example.tpsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.tpsecurity.auth.filter.AdminFilter;
import com.example.tpsecurity.auth.filter.UserFilter;

@Configuration
public class AppConfig {

	@Autowired
	AdminFilter adminFilter;
	
	@Autowired
	UserFilter userFilter;
	
	@Bean
	public FilterRegistrationBean<AdminFilter> adminAuth(){
		FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean();

		registrationBean.setFilter(adminFilter);
		registrationBean.addUrlPatterns("/admin/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}
	
	@Bean
	public FilterRegistrationBean<UserFilter> userAuth(){
		FilterRegistrationBean<UserFilter> registrationBean = new FilterRegistrationBean();

		registrationBean.setFilter(userFilter);
		registrationBean.addUrlPatterns("/user/*");
		registrationBean.setOrder(2);
		return registrationBean;
	}
	
	
}
