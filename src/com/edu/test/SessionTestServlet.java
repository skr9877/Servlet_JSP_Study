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
			out.println("처리 결과 없음");
			
			out.close();	
			return;
		}
		
		if(param.equals("create")){
			session = req.getSession();
			if(session.isNew()) {
				msg = "새로운 세션 생성";
			}
			else {
				msg = "기존 세션 리턴";
			}
		}
		else if(param.equals("delete")) {
			session = req.getSession(false);
			if(session != null) {
				session.invalidate();
				msg = "기존 세션 삭제";
			}
			else {
				msg = "삭제 할 세션 없음";
			}
		}
		else if(param.equals("add")) {
			session = req.getSession(true);
			session.setAttribute("msg", "메세지임둥");
			msg = "세션 객체에 데이터 등록 완료";
		}
		else if(param.equals("get")) {
			session = req.getSession(false);
			if(session != null) {
				String str = (String) session.getAttribute("msg");
				msg = str;
			}
			else {
				msg = "데이터를 추출할 세션 객체가 없음";
			}
		}
		else if(param.equals("remove")) {
			session = req.getSession(false);
			
			if(session != null) {
				session.removeAttribute("msg");
				msg = "msg attribute 삭제 완료";
			}
			else {
				msg = "삭제 할 세션 attribute가 없음";
			}
		}
		else if(param.equals("replace")) {
			session = req.getSession();
			session.setAttribute("msg", "새로운 메세지 입니다.");
			msg = "msg 객체 등록 혹은 변경 완료";
		}
		
		out.println("처리 결과 : " + msg);
		
		out.close();	
	}
	
}
