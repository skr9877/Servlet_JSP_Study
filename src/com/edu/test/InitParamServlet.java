package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet{
	String id, pw;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("id");
		pw = config.getInitParameter("pw");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head><title><h1>INIT 예제</h1></title></head>");
		out.print("<body>");
		
		out.print("<h2>서블릿 초기 정보 추출</h2>");
		out.print("<h3>ID : " + id + "</h3>");
		out.print("<h3>ID : " + pw + "</h3>");
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
	

}
