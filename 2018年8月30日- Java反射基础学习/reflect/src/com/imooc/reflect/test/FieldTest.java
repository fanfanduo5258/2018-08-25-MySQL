package com.imooc.reflect.test;
import java.lang.reflect.Field;
import org.junit.Test;

public class FieldTest {
	@Test
	//���Թ��е�����(û��̫��ķ����Ҫ)
	public void demo1() throws Exception {
		//���Class
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		//���public���ԣ�
		Field field = class1.getField("name"); //getFieldֻ�ܻ�ù�������
		//��������-����ֵ�������� p.name = "����"
		Person p =(Person)class1.newInstance();
		field.set(p, "����");
		//��ȡ��������
		Object obj = field.get(p);
		//��ӡ���
		System.out.println(obj);
	}
	
	@Test
	//����˽�е�����(��Ҫ������ô�)
	public void demo2() throws Exception {
		//���Class
		Class class1 = Class.forName("com.imooc.reflect.test.Person");
		//���private���ԣ�
		Field field = class1.getDeclaredField("sex");
		//��������-����ֵ�������� p.sex = "��"
		Person p =(Person)class1.newInstance();
		//˽�����ԣ���Ҫ����һ���ɷ��ʵ�Ȩ��
		field.setAccessible(true);
		//��������
		field.set(p, "��");
		//��ȡ��������
		Object obj = field.get(p);
		//��ӡ���
		System.out.println(obj);
	}
}
