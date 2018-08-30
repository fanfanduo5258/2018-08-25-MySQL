package com.imooc.reflect.test;


public class Person {
	public String name;
	private String sex;
	
	//无参构造
	public Person() {
		
	}
	
	//带参构造
	public Person(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}

//	//getter和setter
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
	
	//吃东西的方法
	public void eat() {
		System.out.println("吃.......");
	}
	
	//跑步的方法(私有)
	private void run() {
		System.out.println("跑.......");
	}
	
	//跑步的方法(私有)
	public String sayHello(String name) {
		return "Hello " + name;
	}
	
	//toString 
	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + "]";
	}
	
	
	
}
