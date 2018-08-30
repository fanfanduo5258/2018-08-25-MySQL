package com.imooc.reflect.homework1;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class GoodsTest {
	@Test
	/**
	 * 获得无参构造
	 */
	public void demo1() throws Exception {
		//获得类的字节码文件对应的对象
		Class class1 = Class.forName("com.imooc.reflect.Goods");
		//获得无参构造
		Constructor c = class1.getConstructor();
		//无参构造实例化
		Goods goods = (Goods)c.newInstance();
		//调用方法
		goods.display();
	}
	
	@Test
	/**
	 * 获得带参构造
	 */
	public void demo2() throws Exception {
		//获得类的字节码文件对应的对象
		Class class1 = Class.forName("com.imooc.reflect.Goods");
		//获得带参构造
		Constructor c = class1.getConstructor(String.class, String.class, float.class, String.class);
		//无参构造实例化
		Goods goods = (Goods)c.newInstance("1","空调",5000.0f,"变频空调");
		//打印toString
		System.out.println(goods);
	}
}
