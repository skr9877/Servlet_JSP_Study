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
		out.print("<head><title><h1>정보 출력</h1></title></head>");
		out.print("<body>");
		
		
		
		out.print("<h3>" + sc + "</h3><br/>");
		
		out.print(location + "<br/>");
		out.print("서블릿 버전 : " + sc.getMajorVersion() + "." + sc.getMinorVersion() + "<br/>");
		out.print("서버 정보 : " + sc.getServerInfo() + "<br/>");
		out.print("웹 어플리케이션 경로 : " + sc.getContextPath() + "<br/>");
		out.print("웹 어플리케이션 이름 : " + sc.getServletContextName() + "<br/>");
		out.print("파일 실제 경로 : " + sc.getRealPath("/name.html"));
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
}
