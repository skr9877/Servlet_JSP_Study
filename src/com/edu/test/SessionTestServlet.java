package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionTest1")
public class SessionTestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String param = req.getParameter("p");
		String msg = null;
		HttpSession session = null;
		
		if(param == null) { 
			out.println("ó�� ��� ����");
			
			out.close();	
			return;
		}
		
		if(param.equals("create")){
			session = req.getSession();
			if(session.isNew()) {
				msg = "���ο� ���� ����";
			}
			else {
				msg = "���� ���� ����";
			}
		}
		else if(param.equals("delete")) {
			session = req.getSession(false);
			if(session != null) {
				session.invalidate();
				msg = "���� ���� ����";
			}
			else {
				msg = "���� �� ���� ����";
			}
		}
		else if(param.equals("add")) {
			session = req.getSession(true);
			session.setAttribute("msg", "�޼����ӵ�");
			msg = "���� ��ü�� ������ ��� �Ϸ�";
		}
		else if(param.equals("get")) {
			session = req.getSession(false);
			if(session != null) {
				String str = (String) session.getAttribute("msg");
				msg = str;
			}
			else {
				msg = "�����͸� ������ ���� ��ü�� ����";
			}
		}
		else if(param.equals("remove")) {
			session = req.getSession(false);
			
			if(session != null) {
				session.removeAttribute("msg");
				msg = "msg attribute ���� �Ϸ�";
			}
			else {
				msg = "���� �� ���� attribute�� ����";
			}
		}
		else if(param.equals("replace")) {
			session = req.getSession();
			session.setAttribute("msg", "���ο� �޼��� �Դϴ�.");
			msg = "msg ��ü ��� Ȥ�� ���� �Ϸ�";
		}
		
		out.println("ó�� ��� : " + msg);
		
		out.close();	
	}
	
}
