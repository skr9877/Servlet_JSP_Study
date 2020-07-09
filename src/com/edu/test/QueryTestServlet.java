package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		ArrayList<String> hobbylist = new ArrayList<>(Arrays.asList(req.getParameterValues("hobby")));

		Iterator<String> iter = hobbylist.iterator();

		out.print("<html>");
		out.println("<head>Get</head>");

		out.print("<body>");

		out.print("ID : " + id + "<br/>");
		out.print("PW : " + pw + "<br/>");

		while (iter.hasNext()) {
			out.print("hobby : " + iter.next() + "<br/>");
		}

		out.print("</body>");
		out.print("</html>");

		out.close();
	}

	/*
	 * @Override protected void doPost(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * resp.setContentType("text/html;charset=UTF-8"); PrintWriter out =
	 * resp.getWriter(); req.setCharacterEncoding("UTF-8");
	 * 
	 * ServletInputStream input = req.getInputStream();
	 * 
	 * int len = req.getContentLength();
	 * 
	 * byte[] buf = new byte[len];
	 * 
	 * input.readLine(buf, 0, len); String s = new String(buf);
	 * 
	 * String id = req.getParameter("id");
	 * 
	 * out.print("<html>"); out.println("<head>Post</head>");
	 * 
	 * out.print("<body>");
	 * 
	 * out.print("ID = " + id + "<br/>"); out.print("전체문자열 : " + s);
	 * 
	 * out.print("</body>"); out.print("</html>");
	 * 
	 * out.close(); }
	 */

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		req.setCharacterEncoding("UTF-8");
		
		System.out.println("로그 시작");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		//ArrayList<String> hobbylist = new ArrayList<>(Arrays.asList(req.getParameterValues("hobby")));
		String[] hobbylist = req.getParameterValues("hobby");
		
		//Iterator<String> iter = hobbylist.iterator();

		out.print("<html>");
		out.println("<head>Post</head>");

		out.print("<body>");

		out.print("ID : " + id + "<br/>");
		out.print("PW : " + pw + "<br/>");
		
		
		/*
		 * while (iter.hasNext()) { out.print("hobby : " + iter.next() + "<br/>"); }
		 */
		if(hobbylist != null) {
			for(int i = 0; i < hobbylist.length; ++i) {
				System.out.println("로그 = " + hobbylist[i]);
				out.print("hobby : " + hobbylist[i] + "<br/>");
			}
		}

		out.print("</body>");
		out.print("</html>");

		out.close();
	}
	 
}
