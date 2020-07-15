package com.edu.test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

// ���� ���� Ȥ�� ������ ����
@WebListener
public class TestServletContextListener implements ServletContextListener{
	public TestServletContextListener() {
		System.out.println("TestServletContextListener ��ü ����");
	}
	

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servletContext ��ü ����");		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servletContext ��ü �ʱ�ȭ");
	}

}
