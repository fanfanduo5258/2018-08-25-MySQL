package com.junit.test;

public class Calculator {
	//静态变量，用于存储运行结果
	private static int result; 
	
	/**
	 * 加法测试
	 */
	public void add(int n) {
		result = result + n;
	}
	
	/**
	 * 减法测试
	 */
	public void substract(int n) {
		result = result  - 1; //Bug:正确的应该是result = result - n
	}
	
	/**
	 * 乘法测试
	 */
	public void multiply(int n) {
									//此方法尚未写好
	}
	
	/**
	 * 除法的方法
	 */
	public void  divide(int n) throws Exception {
		//判断n如果为0，抛出异常，并错误提示 
		if(n==0) {
			throw new Exception("除数不能为0");
		}
		result = result / n;
	}
	
	/**
	 * 求平方的方法
	 */
	public void square(int n) {
		result =  n * n;
	}
	
	/**
	 * 求平方根的方法
	 */
	public void squareRoot(int n) {
		for(; ;) ;  //Bug死循环
	}
	
	/*
	 * 结果清零的方法
	 */
	public void clear() {
		result = 0;
	}
	
	/*
	 * 返回结果的方法
	 */
	public int getResult() {
		return result;
	}
}
