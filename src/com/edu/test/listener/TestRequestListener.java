package com.edu.test.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class TestRequestListener implements ServletRequestListener{
	public TestRequestListener() {
		System.out.println("TestRequestListener ��ü ����");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("TestRequestListener ��ü ����");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("TestRequestListener ��ü �ʱ�ȭ");
	}

}
