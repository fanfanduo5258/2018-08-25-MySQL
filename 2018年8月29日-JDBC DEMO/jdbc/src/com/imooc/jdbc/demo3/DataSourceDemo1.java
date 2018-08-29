package com.imooc.jdbc.demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.imooc.jdbc.utils.JDBCUtils;
import com.imooc.jdbc.utils.JDBCUtils2;
import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * ���ӳصĲ�����
 * @author Administrator
 *
 */
public class DataSourceDemo1 {
	@Test
	/**
	 * ʹ�������ļ��ķ�ʽ
	 */
	public void demo2() {
		//������ӣ�
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//������ӣ�
			connection = JDBCUtils2.getConnection();
			//��дSQL:
			String sql = "select * from user";
			//Ԥ����SQL:
			preparedStatement = connection.prepareStatement(sql);
			//���ò���(û��)
			//ִ��SQL��
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("uid")+"   "+resultSet.getString("username")+"   "+resultSet.getString("password")+"   "+resultSet.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils2.release(resultSet, preparedStatement, connection);
		}
	}
	
	@Test
	/**
	 * �ֶ��������ӳ�
	 */
	public void demo1() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//������ӣ�
			//�������ӳ�:
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			//�������ӳصĲ�����
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
			dataSource.setUser("root");
			dataSource.setPassword("!Ff52584804");
			dataSource.setMaxPoolSize(20); //���������
			dataSource.setInitialPoolSize(3); //��ʼ��������
			
			//���ӳ��л������
			connection = dataSource.getConnection();
			//��дSQL:
			String sql = "select * from user";
			//Ԥ����SQL:
			preparedStatement = connection.prepareStatement(sql);
			//���ò���(û��)
			//ִ��SQL��
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("uid")+"   "+resultSet.getString("username")+"   "+resultSet.getString("password")+"   "+resultSet.getString("name"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(resultSet, preparedStatement, connection);
		}
	}

}
