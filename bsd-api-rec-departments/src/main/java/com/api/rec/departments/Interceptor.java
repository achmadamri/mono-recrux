package com.api.rec.departments;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptor implements HandlerInterceptor {
	
	private Logger log = LoggerFactory.getLogger(Interceptor.class);

	@Autowired
	private Environment env;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String api = request.getRemoteAddr() + "_" + request.getServletPath();

		int sec = Integer.parseInt(env.getProperty("service.sec"));
		int limit = Integer.parseInt(env.getProperty("service.limit"));
		
		boolean ret = RateLimiter.instance.check(api, sec, limit);
		
		if (ret) {
			log.info("[api:" + api + " pass]");
		} else {
			log.info("[api:" + api + " blocked]");
		}
		
		return ret;
	}
}
