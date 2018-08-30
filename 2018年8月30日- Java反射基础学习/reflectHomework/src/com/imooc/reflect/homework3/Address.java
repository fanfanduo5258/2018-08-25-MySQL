package com.imooc.reflect.homework3;

public class Address {
	//��Ա����
	private String id; //��ַ���
	private String name; //����
	private String address; //��ϸ��ַ
	private int number; //�绰
	
	//�޲ι���
	public Address() {
		
	}
		
	//���ι���
	public Address(String id, String name, String address, int number) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
	}
	//getter��setter
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
	
	//public����
	public void display() {
		System.out.println("����һ����ַ");
	}
	
	//private����
	private void info() {
		System.out.println("����˽�з���");
	}
	
	/**
	 * private�������������Ƚϲ�����name��ֵ�Ƿ�һ�£��Ƚ�������
	 * @param name
	 */
	private void equalsAddress(String name) {
		if(name == "�̶�") {
			System.out.println("���");
		}
		else {
			System.out.println("�����");
		}
	}
}
