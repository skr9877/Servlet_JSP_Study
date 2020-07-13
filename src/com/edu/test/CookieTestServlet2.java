package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookie2")
public class CookieTestServlet2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		Cookie[] list = req.getCookies();
		
		for(int i = 0 ; i < list.length && list != null ; i++) {
			out.println(list[i].getName() + ": " + list[i].getValue() + "<br/>");
			//out.println("지속시간 : " + list[i].getMaxAge());
		}
		
		out.close();
		
	}
}
