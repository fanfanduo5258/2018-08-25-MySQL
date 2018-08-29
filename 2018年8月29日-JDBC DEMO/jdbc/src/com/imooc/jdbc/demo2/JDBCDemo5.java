package com.imooc.jdbc.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.imooc.jdbc.utils.JDBCUtils;

/**
 * PreparedStatement��ʹ��
 */
public class JDBCDemo5 {
	@Test
	/**
	 * ��ѯ��������
	 */
	public void demo5() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		try {
			//������ӣ�
			connection = JDBCUtils.getConnection();
			//��дSQL:
			 String sql = "select  * from  user where uid = ?";
			 //Ԥ����SQL��
			 preparedStatement = connection.prepareStatement(sql);
			 //���ò�����
			 preparedStatement.setObject(1, 2);
			 //ִ��SQL
			 resultSet = preparedStatement.executeQuery();
			 if(resultSet.next()) {
				 System.out.println(resultSet.getInt("uid")+"   "+resultSet.getString("username")+"   "+resultSet.getString("password")+"   "+resultSet.getString("name"));
			 } 
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(resultSet, preparedStatement, connection);;
		}
	}
	
	@Test
	/**
	 * ��ѯ��������
	 */
	public void demo4() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		try {
			//������ӣ�
			connection = JDBCUtils.getConnection();
			//��дSQL:
			 String sql = "select * from  user";
			 //Ԥ����SQL��
			 preparedStatement = connection.prepareStatement(sql);
			 //ִ��SQL
			 resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 System.out.println(resultSet.getInt("uid")+"   "+resultSet.getString("username")+"   "+resultSet.getString("password")+"   "+resultSet.getString("name"));
			 }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(resultSet, preparedStatement, connection);;
		}
	}
	
	@Test
	/**
	 * ɾ������
	 */
	public void demo3() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		try {
			//������ӣ�
			connection = JDBCUtils.getConnection();
			//��дSQL:
			 String sql = "delete from user where uid = ?";
			 //Ԥ����SQL��
			 preparedStatement = connection.prepareStatement(sql);
			 //���ò�����ֵ
			 preparedStatement.setInt(1, 12); //uid
			 //ִ��SQL
			 int i = preparedStatement.executeUpdate();
			 if(i>0) {
				 System.out.println("ɾ���ɹ�!");
			 }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(preparedStatement, connection);
		}
	}
	
	@Test
	/**
	 * �޸�����
	 */
	public void demo2() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		try {
			//������ӣ�
			connection = JDBCUtils.getConnection();
			//��дSQL:
			 String sql = "update user set username=?, password=?, name=? where uid = ?";
			 //Ԥ����SQL��
			 preparedStatement = connection.prepareStatement(sql);
			 //���ò�����ֵ
			 preparedStatement.setString(1, "www"); //username
			 preparedStatement.setString(2, "123456"); //pasword
			 preparedStatement.setString(3, "�Ÿ���"); //name
			 preparedStatement.setInt(4, 10); //uid
			 //ִ��SQL
			 int i = preparedStatement.executeUpdate();
			 if(i>0) {
				 System.out.println("�޸ĳɹ�!");
			 }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(preparedStatement, connection);
		}
	}
	
	@Test
	/**
	 * ��������
	 */
	public void demo1() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		try {
			//������ӣ�
			connection = JDBCUtils.getConnection();
			//��дSQL:
			 String sql = "insert into user values (null,?,?,?)";
			 //Ԥ����SQL��
			 preparedStatement = connection.prepareStatement(sql);
			 //���ò�����ֵ
			 preparedStatement.setString(1, "qqq"); //username
			 preparedStatement.setString(2, "123"); //pasword
			 preparedStatement.setString(3, "����"); //name
			 //ִ��SQL
			 int i = preparedStatement.executeUpdate();
			 if(i>0) {
				 System.out.println("����ɹ�!");
			 }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(preparedStatement, connection);
		}
	}
}
