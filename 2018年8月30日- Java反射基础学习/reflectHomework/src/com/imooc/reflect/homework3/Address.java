package com.imooc.reflect.homework3;

public class Address {
	//成员属性
	private String id; //地址编号
	private String name; //姓名
	private String address; //详细地址
	private int number; //电话
	
	//无参构造
	public Address() {
		
	}
		
	//带参构造
	public Address(String id, String name, String address, int number) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
	}
	//getter和setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	//toString
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", address=" + address + ", number=" + number + "]";
	}
	
	//public方法
	public void display() {
		System.out.println("这是一个地址");
	}
	
	//private方法
	private void info() {
		System.out.println("我是私有方法");
	}
	
	/**
	 * private方法带参数，比较参数和name的值是否一致，比较输出结果
	 * @param name
	 */
	private void equalsAddress(String name) {
		if(name == "短短") {
			System.out.println("相等");
		}
		else {
			System.out.println("不相等");
		}
	}
}
