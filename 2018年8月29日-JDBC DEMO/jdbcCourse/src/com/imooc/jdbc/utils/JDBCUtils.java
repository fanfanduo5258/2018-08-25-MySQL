package com.imooc.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	//实例化连接池
	public static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	/**
	 * 获得连接的方法
	 */
	public static Connection getConnection() throws Exception {
		Connection connection = dataSource.getConnection();
		return connection;
	}
	
	/**
	 * 资源释放的方法
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
