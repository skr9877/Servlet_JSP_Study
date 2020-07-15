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
		//System.out.println("init ȣ�� -- 2"); 
		
		charset = filterConfig.getInitParameter("en");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		//System.out.println("doFilter ȣ�� �� -- 2"); // servlet �� ���� �ڵ�
		req.setCharacterEncoding(charset); // request ���� UTF-8�� ���ڵ� �Ͽ� ���� --> init���� �����丵 ����
		chain.doFilter(req, res);
		//System.out.println("doFilter ȣ�� �� -- 2"); // servlet �� ���� �ڵ�
	}
	
	@Override
	public void destroy() {
		//System.out.println("destroy ȣ�� -- 2"); 
	}
}
