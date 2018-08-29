package com.imooc.jdbc.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo2 {
	@Test
	/**
	 * ��ѯһ����¼
	 */
	public void demo5() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			//ע��������
			Class.forName("com.mysql.jdbc.Driver");
			//�������
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8", "root", "!Ff52584804");
			//����ִ��SQL���Ķ���
			statement = connection.createStatement();
			//��дSQL��
			String sql = "SELECT * FROM user WHERE uid=2";
			//ִ��SQL��
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				System.out.println(resultSet.getInt("uid")+"     "+resultSet.getString("username")+"     "+resultSet.getString("password")+"     "+resultSet.getString("name"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//�ͷ���Դ
			//connection
			if(connection != null) {
				try {
					connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				connection = null;
			}
			//statement
			if(statement != null) {
				try {
					statement.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null;
			}	
			//resultSet
			if(resultSet != null) {
				try {
					resultSet.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				resultSet = null;
			}	
		}
	}
	
	@Test
	/**
	 * ��ѯ���м�¼
	 */
	public void demo4() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			//ע��������
			Class.forName("com.mysql.jdbc.Driver");
			//�������
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8", "root", "!Ff52584804");
			//����ִ��SQL���Ķ���
			statement = connection.createStatement();
			//��дSQL��
			String sql = "SELECT * FROM user";
			//ִ��SQL��
			resultSet = statement.executeQuery(sql);
			//�����������
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("uid")+"     "+resultSet.getString("username")+"     "+resultSet.getString("password")+"     "+resultSet.getString("name"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//�ͷ���Դ
			//connection
			if(connection != null) {
				try {
					connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				connection = null;
			}
			//statement
			if(statement != null) {
				try {
					statement.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null;
			}	
			//resultSet
			if(resultSet != null) {
				try {
					resultSet.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				resultSet = null;
			}	
		}
	}
	
	@Test
	/**
	 * ɾ������
	 */
	public void demo3() {
		Connection connection = null;
		Statement statement = null;
		try {
			//ע������
			Class.forName("com.mysql.jdbc.Driver");
			//�������
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8", "root", "!Ff52584804");
			//����ִ��SQL���Ķ���
			statement = connection.createStatement();
			//��дSQL��
			String sql = "delete from user where uid=4";
			//ִ��SQL��
			int i = statement.executeUpdate(sql);
			//�ж������Ƿ����0
			if(i>0) {
				System.out.println("ɾ���ɹ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//�ͷ���Դ��
			//connection
			if(connection != null) {
				try {
					connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				connection = null;
			}
			//statement
			if(statement != null) {
				try {
					statement.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null;
			}	
		}
	}
	
	@Test
	/**
	 * �޸Ĳ���
	 */
	public void demo2() {
		Connection connection = null;
		Statement statement = null;
		try {
			//ע������
			Class.forName("com.mysql.jdbc.Driver");
			//�������
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8", "root", "!Ff52584804");
			//����ִ��SQL���Ķ���
			statement = connection.createStatement();
			//��дSQL��
			String sql = "update user set username = 'qqq', password='456', name='����' where uid=4";
			//ִ��SQL��
			int i = statement.executeUpdate(sql);
			//�ж������Ƿ����0
			if(i>0) {
				System.out.println("�޸ĳɹ���");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//�ͷ���Դ��
			//connection
			if(connection != null) {
				try {
					connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				connection = null;
			}
			//statement
			if(statement != null) {
				try {
					statement.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null;
			}	
		}
	}
	
	
	@Test
	/**
	 * �������
	 */
	public void demo1() {
		Connection connection = null;
		Statement statement = null;
		try {
			//ע��������
			Class.forName("com.mysql.jdbc.Driver");
			//������ӣ�
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8", "root", "!Ff52584804");
			//���ִ��SQL���Ķ���
			statement = connection.createStatement();
			//��дSQL��
			String sql = "insert into user values(null,'eee','123','����')";
			//ִ��SQL��
			int i = statement.executeUpdate(sql);
			//�ж��Ƿ�������
			if(i>0) {
				System.out.println("����ɹ�!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//�ͷ���Դ��
			//connection
			if(connection != null) {
				try {
					connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				connection = null;
			}
			//statement
			if(statement != null) {
				try {
					statement.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null;
			}		
		}
	}
}
