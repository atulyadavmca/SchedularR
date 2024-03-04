
package com.gov.nha.bis.goldenApi.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(SimpleCorsFilter.class);

	public SimpleCorsFilter() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		String path = request.getRequestURI();

		logger.info("inside cors filter method == "+request.getMethod()+" || "+path);	
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
		response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept,"
				+ " X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers , Authorization,Access-Control-Allow-Origin");		
		response.setHeader("X-XSS-Protection", "1; mode=block");
		response.setHeader("Content-Security-Policy", "form-action 'self'");
		response.setHeader("X-Content-Type-Options", "nosniff");
		response.setHeader("Referrer-Policy", "same-origin");
		response.setHeader("Permissions-Policy", "geolocation=(self)");
		response.setHeader("Strict-Transport-Security", "max-age=31536000 ; includeSubDomains");
		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json");
		} else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void destroy() {
	}


}