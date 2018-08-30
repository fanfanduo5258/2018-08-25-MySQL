package com.imooc.reflect.test;

import org.junit.Test;

public class ClassTest {

	@	Test
	/**
	 * 获得Class对象
	 * 1.通过类名.class
	 * 2.对象.getClass()
	 * 3.Class.forName();
	 */
	public void demo1() throws ClassNotFoundException {
		//1.通过类名.class
		Class clazz1 = Person.class;
		//2. 通过对象.getClss()的方式
		Person person = new Person();
		Class clazz2 = person.getClass();
		//3. Class类froName();
		Class clazz3 = Class.forName("com.imooc.reflect.test.Person");
	}
}
 