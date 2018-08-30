package com.imooc.reflect.homework1;

public class Goods {
	//属性
	private String ID; //商品编号
	private String goodsName; //商品名称
	private float price; //商品价格
	private String desc; //商品描述
	
	//无参构造
	public Goods() {
		
	}

	//带参构造
	public Goods(String iD, String goodsName, float price, String desc) {
		super();
		ID = iD;
		this.goodsName = goodsName;
		this.price = price;
		this.desc = desc;
	}

	//getter和setter方法
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

	//toString方法
	@Override
	public String toString() {
		return "Goods [ID=" + ID + ", goodsName=" + goodsName + ", price=" + price + ", desc=" + desc + "]";
	} 
	
	//输出商品信息方法
	public void display() {
		System.out.println("商品信息");
	}
}
