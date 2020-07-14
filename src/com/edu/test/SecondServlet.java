package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SecondServlet!");
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Test</title></head>");
		out.print("<body><h1>have a nice day</h1>");
		out.print("¾È³ç µðÁö¸ó");
		
		out.print("</body></html>");
		
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Do Post!");
	}
	
}
