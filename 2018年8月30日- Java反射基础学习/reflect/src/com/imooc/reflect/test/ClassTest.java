package com.imooc.reflect.test;

import org.junit.Test;

public class ClassTest {

	@	Test
	/**
	 * ���Class����
	 * 1.ͨ������.class
	 * 2.����.getClass()
	 * 3.Class.forName();
	 */
	public void demo1() throws ClassNotFoundException {
		//1.ͨ������.class
		Class clazz1 = Person.class;
		//2. ͨ������.getClss()�ķ�ʽ
		Person person = new Person();
		Class clazz2 = person.getClass();
		//3. Class��froName();
		Class clazz3 = Class.forName("com.imooc.reflect.test.Person");
	}
}
 