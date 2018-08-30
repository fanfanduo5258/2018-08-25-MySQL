package com.imooc.reflect.homework2;

import java.lang.reflect.Field;

import org.junit.Test;

public class FieldTest {
	/**
	 * 获取public属性的方法
	 * @throws Exception
	 */
	@Test
	public void demo1() throws Exception {
		//获得Class
		Class class1 = Class.forName("com.imooc.reflect.test1.Book");
		//获得public属性
		Field field = class1.getField("price");
		//设置属性
		Book book = (Book)class1.newInstance();
		field.set(book, 45);
		//获取设置属性
		Object object = field.get(book);
		//打印输出
		System.out.println(object);
	}
	
	/**
	 * 获取private属性的方法
	 * @throws Exception
	 */
	@Test
	public void demo2() throws Exception {
		//获得Class
		Class class1 = Class.forName("com.imooc.reflect.test1.Book");
		//获得private
		Field field1 = class1.getDeclaredField("id");
		Field field2 = class1.getDeclaredField("bookname");
		//设置属性
		Book book = (Book)class1.newInstance();
		//私有属性访问权限
		field1.setAccessible(true);
		field2.setAccessible(true);
		//设置属性
		field1.set(book, "001");
		field2.set(book, "围城");
		//获取设置属性打印输出
		Object object1 = field1.get(book);
		Object object2 = field2.get(book);
		//打印输出
		System.out.println(object1);
		System.out.println(object2);
	}
}
