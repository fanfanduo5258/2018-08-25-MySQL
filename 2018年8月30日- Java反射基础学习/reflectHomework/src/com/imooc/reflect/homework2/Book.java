package com.imooc.reflect.homework2;

public class Book {
	//����
	private String id;
	private String bookname;
	public float price;

	//�޲ι���
	public Book() {
		
	}
	
	//���ι���
	public Book(String id, String bookname, float price) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.price = price;
	}

	//toString
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookname=" + bookname + ", price=" + price + "]";
	}
}
