package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie3")
public class CookieTestServlet3 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		Cookie[] list = req.getCookies();
		
		int cnt = 0;
		
		for(int i = 0 ; i < list.length && list != null ; i++) {
			if(list[i].getName().contentEquals("count")) {
				cnt = Integer.parseInt(list[i].getValue());
			}
		}
		
		++cnt;
		
		Cookie c = new Cookie("count", cnt + "");
		c.setMaxAge(60*60);
		
		resp.addCookie(c);
		
		out.print("<h1> ¹æ¹® È½¼ö : " + cnt + "<br/");
		
		out.close();
		
	}
}
