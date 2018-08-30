package com.imooc.reflect.test;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Test;

public class ConstructorTest {
	@Test
	/**
	 * 获得无参构造
	 */
	public void demo1() throws Exception {
		//获得类的字节码文件对应的对象：
		Class class1  = Class.forName("com.imooc.reflect.test.Person");
		//获得无参构造
		Constructor c = class1.getConstructor();
		//无参构造实例化 相当于Person persion = new Person()
		Person person = (Person)c.newInstance();
		//调用方法
		person.eat();
	}
	
	@Test
	/**
	 * 获得带参构造
	 */
	public void demo2() throws Exception {
		//获得类的字节码文件对应的对象：
		Class class1  = Class.forName("com.imooc.reflect.test.Person");
		//获得带参构造
		Constructor c = class1.getConstructor(String.class, String.class);
		//无参构造实例化 相当于Person persion = new Person("张三","男");
		Person person = (Person)c.newInstance("张三","男");
		//测试
		System.out.println(person);
	}
}
