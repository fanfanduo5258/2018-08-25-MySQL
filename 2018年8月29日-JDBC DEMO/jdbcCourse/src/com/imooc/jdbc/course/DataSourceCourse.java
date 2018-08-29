package com.imooc.jdbc.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.imooc.jdbc.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *���ӳ��������ݿ�
 */
public class DataSourceCourse {
	/*
	 * �ֶ����÷�ʽ
	 */
	public void demo1() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//�������ӳأ�
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			//�������ӳز���
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
			dataSource.setUser("root");
			dataSource.setPassword("!Ff52584804");
			dataSource.setMaxPoolSize(20);
			dataSource.setInitialPoolSize(3);		
			//���ӳ��л������
			connection = dataSource.getConnection();
			//��дSQL��
			String sql = "select * from user";
			//Ԥ����SQL
			preparedStatement = connection.prepareStatement(sql);
			//���ò���(û��)
			//ִ��SQL��
			resultSet = preparedStatement.executeQuery();
			//��ӡ�������
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id")+"   "+resultSet.getString("name")+"   "+resultSet.getString("category")+"   "+resultSet.getString("desp")+"   "+resultSet.getString("createTime"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//�ͷ���Դ
			JDBCUtils.release(connection, preparedStatement, resultSet);
		}
	}
	
	/*
	 * �����ļ���ʽ
	 */
	@Test
	public void demo() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet  resultSet = null;
		try {
			//�������
			connection = JDBCUtils.getConnection();
			//��дSQL
			String sql = "select * from course";
			//Ԥ����SQL
			preparedStatement = connection.prepareStatement(sql);
			//���ò���(û��)
			//ִ��SQL
			resultSet =preparedStatement.executeQuery();
			//��ӡ����
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id")+"   "+resultSet.getString("name")+"   "+resultSet.getString("category")+"   "+resultSet.getString("desp")+"   "+resultSet.getString("createTime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(connection, preparedStatement, resultSet);;
		}
	}
}
