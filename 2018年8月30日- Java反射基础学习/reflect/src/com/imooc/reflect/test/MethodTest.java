package com.imooc.reflect.test;

import java.lang.reflect.Method;

import org.junit.Test;

public class MethodTest {
	@Test
	/**
	 * 测试公有的方法
	 */
	public void demo1() throws Exception {
		//获得Class
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		//实例化：
		Person person = (Person) class1.newInstance();
		//获得公有方法
		Method method = class1.getMethod("eat");
		//执行该方法：
		method.invoke(person); //类似于person.eat();
	}
	
	@Test
	/**
	 * 测试私有的方法
	 */
	public void demo2() throws Exception {
		//获得Class
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		//实例化：
		Person person = (Person) class1.newInstance();
		//获得私有方法
		Method declaredMethod = class1.getDeclaredMethod("run");
		//设置私有属性访问权限
		declaredMethod.setAccessible(true);
		//执行该方法:
		declaredMethod.invoke(person); //类似于person.run();
	}
	
	@Test
	//测试私有的方法带参数和返回值
	public void demo3() throws Exception {
		//获得Class
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		//实例化：
		Person person = (Person) class1.newInstance();
		//获得方法
		Method declaredMethod = class1.getDeclaredMethod("sayHello",String.class);
		//设置私有属性访问权限
		declaredMethod.setAccessible(true);
		//执行该方法:
		Object obj = declaredMethod.invoke(person,"Tom"); //类似于person.run();
		System.out.println(obj);
	}
}
