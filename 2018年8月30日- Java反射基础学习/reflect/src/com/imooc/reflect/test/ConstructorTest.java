package com.imooc.reflect.test;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Test;

public class ConstructorTest {
	@Test
	/**
	 * ����޲ι���
	 */
	public void demo1() throws Exception {
		//�������ֽ����ļ���Ӧ�Ķ���
		Class class1  = Class.forName("com.imooc.reflect.test.Person");
		//����޲ι���
		Constructor c = class1.getConstructor();
		//�޲ι���ʵ���� �൱��Person persion = new Person()
		Person person = (Person)c.newInstance();
		//���÷���
		person.eat();
	}
	
	@Test
	/**
	 * ��ô��ι���
	 */
	public void demo2() throws Exception {
		//�������ֽ����ļ���Ӧ�Ķ���
		Class class1  = Class.forName("com.imooc.reflect.test.Person");
		//��ô��ι���
		Constructor c = class1.getConstructor(String.class, String.class);
		//�޲ι���ʵ���� �൱��Person persion = new Person("����","��");
		Person person = (Person)c.newInstance("����","��");
		//����
		System.out.println(person);
	}
}
