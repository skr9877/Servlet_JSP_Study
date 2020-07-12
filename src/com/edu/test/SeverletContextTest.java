package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/context_test1")
public class SeverletContextTest extends HttpServlet{
	ServletContext sc;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//sc = config.getServletContext();
		super.init(config);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		sc = this.getServletContext();
		String location = sc.getInitParameter("ContextConfig");
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title><h1>���� ���</h1></title></head>");
		out.print("<body>");
		
		
		
		out.print("<h3>" + sc + "</h3><br/>");
		
		out.print(location + "<br/>");
		out.print("���� ���� : " + sc.getMajorVersion() + "." + sc.getMinorVersion() + "<br/>");
		out.print("���� ���� : " + sc.getServerInfo() + "<br/>");
		out.print("�� ���ø����̼� ��� : " + sc.getContextPath() + "<br/>");
		out.print("�� ���ø����̼� �̸� : " + sc.getServletContextName() + "<br/>");
		out.print("���� ���� ��� : " + sc.getRealPath("/name.html"));
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
