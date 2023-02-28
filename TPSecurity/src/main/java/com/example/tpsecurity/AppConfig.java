package com.example.tpsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.tpsecurity.auth.filter.AdminFilter;

@Configuration
public class AppConfig {

	@Autowired
	AdminFilter adminFilter;
	
	@Bean
	public FilterRegistrationBean<AdminFilter> filterRegistrationBean(){
		FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean();
		
		
		registrationBean.setFilter(adminFilter);
		registrationBean.addUrlPatterns("/admin/*");
		registrationBean.setOrder(1);
		
		
		return registrationBean;
	}
}
