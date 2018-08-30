package com.imooc.reflect.homework3;

import java.lang.reflect.Method;

import org.junit.Test;

public class AddressTest {
	/**
	 * 测试public方法
	 * @throws Exception 
	 */
	@Test
	public void demo1() throws Exception{
		//获得Class
		Class class1 = Class.forName("com.imooc.reflect.homework3.Address");
		//实例化
		Address address = (Address) class1.newInstance();
		//获得私有方法
		Method method = class1.getMethod("display");
		//执行该方法
		method.invoke(address);
	}
	
	/**
	 * 测试private方法
	 * @throws Exception 
	 */
	@Test
	public void demo2() throws Exception{
		//获得Class
		Class class1 = Class.forName("com.imooc.reflect.homework3.Address");
		//实例化
		Address address = (Address) class1.newInstance();
		//获得私有方法
		Method declaredMethod = class1.getDeclaredMethod("info");
		//设置访问权限
		declaredMethod.setAccessible(true);
		//执行该方法
		declaredMethod.invoke(address);
	}
	
	/**
	 * 测试private带参数方法
	 * @throws Exception 
	 */
	@Test
	public void demo3() throws Exception{
		//获得Class
		Class class1 = Class.forName("com.imooc.reflect.homework3.Address");
		//实例化
		Address address = (Address) class1.newInstance();
		//获得私有方法
		Method declaredMethod = class1.getDeclaredMethod("equalsAddress",String.class);
		//设置访问权限
		declaredMethod.setAccessible(true);
		//执行该方法
		declaredMethod.invoke(address,"短短");
	}
}
