package com.imooc.reflect.test;

import java.lang.reflect.Method;

import org.junit.Test;

public class MethodTest {
	@Test
	/**
	 * ���Թ��еķ���
	 */
	public void demo1() throws Exception {
		//���Class
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		//ʵ������
		Person person = (Person) class1.newInstance();
		//��ù��з���
		Method method = class1.getMethod("eat");
		//ִ�и÷�����
		method.invoke(person); //������person.eat();
	}
	
	@Test
	/**
	 * ����˽�еķ���
	 */
	public void demo2() throws Exception {
		//���Class
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		//ʵ������
		Person person = (Person) class1.newInstance();
		//���˽�з���
		Method declaredMethod = class1.getDeclaredMethod("run");
		//����˽�����Է���Ȩ��
		declaredMethod.setAccessible(true);
		//ִ�и÷���:
		declaredMethod.invoke(person); //������person.run();
	}
	
	@Test
	//����˽�еķ����������ͷ���ֵ
	public void demo3() throws Exception {
		//���Class
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		//ʵ������
		Person person = (Person) class1.newInstance();
		//��÷���
		Method declaredMethod = class1.getDeclaredMethod("sayHello",String.class);
		//����˽�����Է���Ȩ��
		declaredMethod.setAccessible(true);
		//ִ�и÷���:
		Object obj = declaredMethod.invoke(person,"Tom"); //������person.run();
		System.out.println(obj);
	}
}
