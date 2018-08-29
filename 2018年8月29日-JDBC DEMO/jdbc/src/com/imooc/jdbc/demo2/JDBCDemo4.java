package com.imooc.jdbc.demo2;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.imooc.jdbc.utils.JDBCUtils;


public class JDBCDemo4{
	@Test
	/**
	 * ����SQLע��©���ķ���
	 */
	public void demo1() {
		//���ñ����login�����������û��������룬�ж����ݿ����Ƿ��и�����
		boolean flag = JDBCDemo4.login2("aaa","123");
		if(flag==true) {
			System.out.println("��¼�ɹ�!");
		}
		else {
			System.out.println("��¼ʧ��!");
		}
	}
	
	/**
	 * ��¼ʱ���ݿ���֤�˺�����ķ���
	 * ����SQLע��©���ķ���
	 */
	public static boolean login2(String username, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean flag = false;
		try {
			//�������:
			connection = JDBCUtils.getConnection();
			//��дSQL: ?Ϊռλ��
			String sql = "select * from user where username = ? and password = ?";
			//Ԥ����SQL��
			preparedStatement = connection.prepareStatement(sql);
			//���ò���:����1Ϊ�ڼ���?��λ�ã�����2Ϊֵ
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			//ִ��SQL��
			resultSet = preparedStatement.executeQuery();
			//�жϽ����
			if(resultSet.next()) {
				flag = true;
			}
			else {
				flag = false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(resultSet, preparedStatement, connection);
		}
		return flag;
	}
	
	/**
	 * ��¼ʱ���ݿ���֤�˺�����ķ���
	 * �õ�¼���������SQLע��©��
	 */
	public static boolean login(String username, String password) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		boolean flag = false;
		try {
			//�������
			connection = JDBCUtils.getConnection();
			//����ִ��SQL���Ķ���
			statement = connection.createStatement();
			//��дSQL��
			String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
			//ִ��SQL��
			resultSet = statement.executeQuery(sql);
			//�жϽ�������Ƿ�������
			if(resultSet.next()) {
				flag = true;
			}
			else {
				flag = false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(resultSet, statement, connection);
		}
		return flag;
	}
}

