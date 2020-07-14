package com.edu.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "timer", urlPatterns = "/third", initParams = @WebInitParam(name = "en", value = "UTF-8"))
public class FlowFilterThree implements Filter {
	String charset;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init 호출 -- 3"); 
		
		charset = filterConfig.getInitParameter("en");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("doFilter 호출 전 -- 3"); // servlet 전 실행 코드
		long startTime = System.currentTimeMillis();
		
		req.setCharacterEncoding(charset); // request 값에 UTF-8로 인코딩 하여 전달 --> init에서 리팩토링 가능
		chain.doFilter(req, res);
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("수행 시간 : " + (endTime - startTime) + " ms");
		System.out.println("doFilter 호출 후 -- 3"); // servlet 전 실행 코드
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 호출 -- 3"); 
	}
}
