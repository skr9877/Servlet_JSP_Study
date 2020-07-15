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
		//System.out.println("init ȣ�� -- 1"); 
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		//System.out.println("doFilter ȣ�� �� -- 1"); // servlet �� ���� �ڵ�
		chain.doFilter(req, res);
		//System.out.println("doFilter ȣ�� �� -- 1"); // servlet �� ���� �ڵ�
	}
	
	@Override
	public void destroy() {
		//System.out.println("destroy ȣ�� -- 1"); 
	}
}
