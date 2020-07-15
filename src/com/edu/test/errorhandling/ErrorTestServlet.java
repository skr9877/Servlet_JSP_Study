package com.edu.test.errorhandling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/errorTest1")
public class ErrorTestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
//		String getquery = req.getQueryString();
//		
//		out.print("Query : " + getquery + "<br/>");
		
		try {
			String getquery = req.getQueryString();
			
			out.print("Query : " + getquery + "<br/>");
			
			out.print("Query 길이: " + getquery.length());
		}
		catch(NullPointerException e1) {
			out.print("쿼리 길이 찾는 중 에러 발생<br/>" );
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		
		out.print("Done!");
		
		out.close();
	}
	
}
