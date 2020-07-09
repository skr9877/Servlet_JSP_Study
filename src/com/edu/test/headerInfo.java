package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headerinfo")
public class headerInfo extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title><h1>정보 출력</h1></title></head>");
		out.print("<body>");
		
		out.print("<h3>헤더 정보 관련 정보</h3>");
		
		Enumeration<String> em = req.getHeaderNames();
		
		while(em.hasMoreElements()) {
			String s = em.nextElement();
			out.print(s + ": " + req.getHeader(s) + "<br/>");
		}
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
	

}
