package com.imooc.reflect.homework1;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class GoodsTest {
	@Test
	/**
	 * ����޲ι���
	 */
	public void demo1() throws Exception {
		//�������ֽ����ļ���Ӧ�Ķ���
		Class class1 = Class.forName("com.imooc.reflect.Goods");
		//����޲ι���
		Constructor c = class1.getConstructor();
		//�޲ι���ʵ����
		Goods goods = (Goods)c.newInstance();
		//���÷���
		goods.display();
	}
	
	@Test
	/**
	 * ��ô��ι���
	 */
	public void demo2() throws Exception {
		//�������ֽ����ļ���Ӧ�Ķ���
		Class class1 = Class.forName("com.imooc.reflect.Goods");
		//��ô��ι���
		Constructor c = class1.getConstructor(String.class, String.class, float.class, String.class);
		//�޲ι���ʵ����
		Goods goods = (Goods)c.newInstance("1","�յ�",5000.0f,"��Ƶ�յ�");
		//��ӡtoString
		System.out.println(goods);
	}
}
