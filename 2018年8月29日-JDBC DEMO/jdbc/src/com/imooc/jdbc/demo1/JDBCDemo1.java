package com.imooc.jdbc.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo1 {
	
	@Test
	/**
	 * JDBC��Դ���ͷ�
	 */
	public void demo2() {
		//Ϊ���ͷ���Դ��MySQL��������try��
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			//1.��������
//			DriverManager.registerDriver(new Driver()); //�ᵼ������ע������
			Class.forName("com.mysql.jdbc.Driver"); //
			
			//2.�������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8", "root","!Ff52584804");
			
			//3.����ִ��SQL���Ķ��󣬲���ִ��SQL
			//3.1 ����ִ��sql�Ķ���
			String sql = "select * from user";
			statement = conn.createStatement();

			//3.2 ִ��sql
			resultSet = statement.executeQuery(sql);
			//3.3 ѭ����MySQL�е�����
			while(resultSet.next()) {
				int uid = resultSet.getInt("uid");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				
				System.out.println(uid+"      "+username+"      "+password+"      "+name);
			}
			

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//4.�ͷ���Դ
			//4.1 resultSet�ͷ�
			if(resultSet != null) {
				try {
					resultSet.close();
				}
				catch(SQLException e) {
					resultSet = null; //�������ջ���
				}
			}
			//4.2 statement�ͷ�
			if(statement != null) {
				try {
					statement.close();
				} 
				catch (SQLException e) {
					statement = null; //�������ջ���
				}
			}
			//4.3 conn�ͷ�
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					conn = null; //�������ջ���
				}
			}
		}
	}
}


