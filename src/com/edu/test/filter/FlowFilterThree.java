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
		System.out.println("init ȣ�� -- 3"); 
		
		charset = filterConfig.getInitParameter("en");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("doFilter ȣ�� �� -- 3"); // servlet �� ���� �ڵ�
		long startTime = System.currentTimeMillis();
		
		req.setCharacterEncoding(charset); // request ���� UTF-8�� ���ڵ� �Ͽ� ���� --> init���� �����丵 ����
		chain.doFilter(req, res);
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("���� �ð� : " + (endTime - startTime) + " ms");
		System.out.println("doFilter ȣ�� �� -- 3"); // servlet �� ���� �ڵ�
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy ȣ�� -- 3"); 
	}
}
