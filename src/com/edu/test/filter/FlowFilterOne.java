package com.edu.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FlowFilterOne implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//System.out.println("init 호출 -- 1"); 
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		//System.out.println("doFilter 호출 전 -- 1"); // servlet 전 실행 코드
		chain.doFilter(req, res);
		//System.out.println("doFilter 호출 후 -- 1"); // servlet 후 실행 코드
	}
	
	@Override
	public void destroy() {
		//System.out.println("destroy 호출 -- 1"); 
	}
}
