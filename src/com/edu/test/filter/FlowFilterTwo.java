package com.edu.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FlowFilterTwo implements Filter {
	String charset;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//System.out.println("init 호출 -- 2"); 
		
		charset = filterConfig.getInitParameter("en");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		//System.out.println("doFilter 호출 전 -- 2"); // servlet 전 실행 코드
		req.setCharacterEncoding(charset); // request 값에 UTF-8로 인코딩 하여 전달 --> init에서 리팩토링 가능
		chain.doFilter(req, res);
		//System.out.println("doFilter 호출 후 -- 2"); // servlet 후 실행 코드
	}
	
	@Override
	public void destroy() {
		//System.out.println("destroy 호출 -- 2"); 
	}
}
