package com.imooc.reflect.homework2;

public class Book {
	//属性
	private String id;
	private String bookname;
	public float price;

	//无参构造
	public Book() {
		
	}
	
	//带参构造
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
