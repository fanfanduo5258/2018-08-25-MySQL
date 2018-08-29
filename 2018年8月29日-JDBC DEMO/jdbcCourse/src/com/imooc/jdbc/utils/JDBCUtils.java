package com.imooc.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	//ʵ�������ӳ�
	public static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	/**
	 * ������ӵķ���
	 */
	public static Connection getConnection() throws Exception {
		Connection connection = dataSource.getConnection();
		return connection;
	}
	
	/**
	 * ��Դ�ͷŵķ���
	 */
	public static void release(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		//connection
		if(connection != null) {
			try {
				connection.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			connection = null;
		}
		//PreparedStatement
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			preparedStatement = null;
		}
		//ResultSet
		if(resultSet != null) {
			try {
				resultSet.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			resultSet = null;
		}
	}
	
	public static void release(Connection connection, PreparedStatement preparedStatement) {
		//connection
		if(connection != null) {
			try {
				connection.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			connection = null;
		}
		//PreparedStatement
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			preparedStatement = null;
		}
	}
}
