package com.imooc.reflect.test;
import java.lang.reflect.Field;
import org.junit.Test;

public class FieldTest {
	@Test
	//测试公有的属性(没有太大的反射必要)
	public void demo1() throws Exception {
		//获得Class
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		//获得public属性：
		Field field = class1.getField("name"); //getField只能获得公有属性
		//操作属性-设置值：类似于 p.name = "李四"
		Person p =(Person)class1.newInstance();
		field.set(p, "李四");
		//获取设置属性
		Object obj = field.get(p);
		//打印输出
		System.out.println(obj);
	}
	
	@Test
	//测试私有的属性(主要反射的用处)
	public void demo2() throws Exception {
		//获得Class
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		//获得private属性：
		Field field = class1.getDeclaredField("sex");
		//操作属性-设置值：类似于 p.sex = "男"
		Person p =(Person)class1.newInstance();
		//私有属性，需要设置一个可访问的权限
		field.setAccessible(true);
		//设置属性
		field.set(p, "男");
		//获取设置属性
		Object obj = field.get(p);
		//打印输出
		System.out.println(obj);
	}
}
