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

import org.springframework.context.annotation.Configuration;

import com.gov.nha.bis.goldenApi.controller.NhaGoldenApiBaseController;


@Configuration
public class GZIPFilter extends NhaGoldenApiBaseController  implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException 
	{
		if (req instanceof HttpServletRequest) {
			HttpServletRequest request = (HttpServletRequest) req;

			HttpServletResponse response = (HttpServletResponse) res;
			String ae = request.getHeader("accept-encoding");
			if (ae != null && ae.indexOf("gzip") != -1) {
				GZIPResponseWrapper wrappedResponse = new GZIPResponseWrapper(response);
				chain.doFilter(req, wrappedResponse);
				wrappedResponse.finishResponse();
				//try{saveEventLogs();}catch(Exception ex){}
				return;
			}
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig filterConfig) 
	{
		
	}

	public void destroy() {
		// noop
	}
	
	
}
