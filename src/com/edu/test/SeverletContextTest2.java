package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/context_test2")
public class SeverletContextTest2 extends HttpServlet{
	ServletContext sc;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		sc = this.getServletContext();
		String location = sc.getInitParameter("ContextConfig");
		
		ShareObject obj1 = new ShareObject();
		obj1.setCount(100);
		obj1.setStr("��ü ���� �׽�Ʈ1");
		
		sc.setAttribute("data1", obj1);
		
		ShareObject obj2 = new ShareObject();
		obj2.setCount(200);
		obj2.setStr("��ü ���� �׽�Ʈ2");
		
		sc.setAttribute("data2", obj2);
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title><h1>��ü ��� �Ϸ�</h1></title></head>");
		out.print("<body>");
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
