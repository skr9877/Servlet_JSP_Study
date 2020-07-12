package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/context_test3")
public class SeverletContextTest3 extends HttpServlet{
	ServletContext sc;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		sc = this.getServletContext();
		String location = sc.getInitParameter("ContextConfig");
		
		ShareObject obj1 = (ShareObject) sc.getAttribute("data1");
		ShareObject obj2 = (ShareObject) sc.getAttribute("data2");
		
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title><h1>∞¥√º »Æ¿Œ</h1></title></head>");
		out.print("<body>");
			
		out.print("DATA 1 : " + obj1.getCount() + ", " + obj1.getStr() + "<br/>");
		out.print("DATA 2 : " + obj2.getCount() + ", " + obj2.getStr() + "<br/>");
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
