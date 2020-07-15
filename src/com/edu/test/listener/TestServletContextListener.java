package com.edu.test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

// 서버 실행 혹은 중지시 실행
@WebListener
public class TestServletContextListener implements ServletContextListener{
	public TestServletContextListener() {
		System.out.println("TestServletContextListener 객체 생성");
	}
	

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servletContext 객체 삭제");		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servletContext 객체 초기화");
	}

}
