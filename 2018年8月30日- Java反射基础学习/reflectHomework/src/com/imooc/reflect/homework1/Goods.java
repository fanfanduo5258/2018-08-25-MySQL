package com.imooc.reflect.homework1;

public class Goods {
	//����
	private String ID; //��Ʒ���
	private String goodsName; //��Ʒ����
	private float price; //��Ʒ�۸�
	private String desc; //��Ʒ����
	
	//�޲ι���
	public Goods() {
		
	}

	//���ι���
	public Goods(String iD, String goodsName, float price, String desc) {
		super();
		ID = iD;
		this.goodsName = goodsName;
		this.price = price;
		this.desc = desc;
	}

	//getter��setter����
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	//toString����
	@Override
	public String toString() {
		return "Goods [ID=" + ID + ", goodsName=" + goodsName + ", price=" + price + ", desc=" + desc + "]";
	} 
	
	//�����Ʒ��Ϣ����
	public void display() {
		System.out.println("��Ʒ��Ϣ");
	}
}
