package com.api.rec.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorRegistry implements WebMvcConfigurer {
	@Autowired
	private Interceptor interceptor;

	@Override
	public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
		registry.addInterceptor(interceptor);
	}
}
