package com.imooc.reflect.test;


public class Person {
	public String name;
	private String sex;
	
	//�޲ι���
	public Person() {
		
	}
	
	//���ι���
	public Person(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}

//	//getter��setter
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getSex() {
//		return sex;
//	}
//
//	public void setSex(String sex) {
//		this.sex = sex;
//	}
	
	//�Զ����ķ���
	public void eat() {
		System.out.println("��.......");
	}
	
	//�ܲ��ķ���(˽��)
	private void run() {
		System.out.println("��.......");
	}
	
	//�ܲ��ķ���(˽��)
	public String sayHello(String name) {
		return "Hello " + name;
	}
	
	//toString 
	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + "]";
	}
	
	
	
}
