package com.junit.test;

public class Calculator {
	//��̬���������ڴ洢���н��
	private static int result; 
	
	/**
	 * �ӷ�����
	 */
	public void add(int n) {
		result = result + n;
	}
	
	/**
	 * ��������
	 */
	public void substract(int n) {
		result = result  - 1; //Bug:��ȷ��Ӧ����result = result - n
	}
	
	/**
	 * �˷�����
	 */
	public void multiply(int n) {
									//�˷�����δд��
	}
	
	/**
	 * �����ķ���
	 */
	public void  divide(int n) throws Exception {
		//�ж�n���Ϊ0���׳��쳣����������ʾ 
		if(n==0) {
			throw new Exception("��������Ϊ0");
		}
		result = result / n;
	}
	
	/**
	 * ��ƽ���ķ���
	 */
	public void square(int n) {
		result =  n * n;
	}
	
	/**
	 * ��ƽ�����ķ���
	 */
	public void squareRoot(int n) {
		for(; ;) ;  //Bug��ѭ��
	}
	
	/*
	 * �������ķ���
	 */
	public void clear() {
		result = 0;
	}
	
	/*
	 * ���ؽ���ķ���
	 */
	public int getResult() {
		return result;
	}
}
