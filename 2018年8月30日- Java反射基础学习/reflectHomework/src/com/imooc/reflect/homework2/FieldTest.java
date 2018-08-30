package com.imooc.reflect.homework2;

import java.lang.reflect.Field;

import org.junit.Test;

public class FieldTest {
	/**
	 * ��ȡpublic���Եķ���
	 * @throws Exception
	 */
	@Test
	public void demo1() throws Exception {
		//���Class
		Class class1 = Class.forName("com.imooc.reflect.test1.Book");
		//���public����
		Field field = class1.getField("price");
		//��������
		Book book = (Book)class1.newInstance();
		field.set(book, 45);
		//��ȡ��������
		Object object = field.get(book);
		//��ӡ���
		System.out.println(object);
	}
	
	/**
	 * ��ȡprivate���Եķ���
	 * @throws Exception
	 */
	@Test
	public void demo2() throws Exception {
		//���Class
		Class class1 = Class.forName("com.imooc.reflect.test1.Book");
		//���private
		Field field1 = class1.getDeclaredField("id");
		Field field2 = class1.getDeclaredField("bookname");
		//��������
		Book book = (Book)class1.newInstance();
		//˽�����Է���Ȩ��
		field1.setAccessible(true);
		field2.setAccessible(true);
		//��������
		field1.set(book, "001");
		field2.set(book, "Χ��");
		//��ȡ�������Դ�ӡ���
		Object object1 = field1.get(book);
		Object object2 = field2.get(book);
		//��ӡ���
		System.out.println(object1);
		System.out.println(object2);
	}
}
