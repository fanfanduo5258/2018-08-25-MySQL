package com.imooc.reflect.homework3;

import java.lang.reflect.Method;

import org.junit.Test;

public class AddressTest {
	/**
	 * ����public����
	 * @throws Exception 
	 */
	@Test
	public void demo1() throws Exception{
		//���Class
		Class class1 = Class.forName("com.imooc.reflect.homework3.Address");
		//ʵ����
		Address address = (Address) class1.newInstance();
		//���˽�з���
		Method method = class1.getMethod("display");
		//ִ�и÷���
		method.invoke(address);
	}
	
	/**
	 * ����private����
	 * @throws Exception 
	 */
	@Test
	public void demo2() throws Exception{
		//���Class
		Class class1 = Class.forName("com.imooc.reflect.homework3.Address");
		//ʵ����
		Address address = (Address) class1.newInstance();
		//���˽�з���
		Method declaredMethod = class1.getDeclaredMethod("info");
		//���÷���Ȩ��
		declaredMethod.setAccessible(true);
		//ִ�и÷���
		declaredMethod.invoke(address);
	}
	
	/**
	 * ����private����������
	 * @throws Exception 
	 */
	@Test
	public void demo3() throws Exception{
		//���Class
		Class class1 = Class.forName("com.imooc.reflect.homework3.Address");
		//ʵ����
		Address address = (Address) class1.newInstance();
		//���˽�з���
		Method declaredMethod = class1.getDeclaredMethod("equalsAddress",String.class);
		//���÷���Ȩ��
		declaredMethod.setAccessible(true);
		//ִ�и÷���
		declaredMethod.invoke(address,"�̶�");
	}
}
