package com.edu.test.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class TestSessionAttributeListener implements HttpSessionAttributeListener{
	public TestSessionAttributeListener() {
		System.out.println("TestSessionListener ��ü ����");
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("���� ��ü �Ӽ� �߰�");
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("���� ��ü �Ӽ� ����");
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("���� ��ü �Ӽ� ����");
		
	}
	
	
	
}
