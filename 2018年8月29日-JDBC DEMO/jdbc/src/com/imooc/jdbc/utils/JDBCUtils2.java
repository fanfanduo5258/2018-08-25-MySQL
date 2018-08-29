package com.imooc.jdbc.utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * JDBC�Ĺ�����
 * @author Administrator
 *
 */
public class JDBCUtils2 {	
		private  static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
		/**
		 * ������ӵķ���
		 */
		public static Connection getConnection() throws Exception {
			//��ȡע�������ķ�����ʵ���ڹ������������ʱ��ֻ�������ӷ���
			Connection connection = dataSource.getConnection();
			return connection;
		}
		
		/**
		 * ��Դ�ͷŵķ���
		 */	
		public static void release(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
			//ResultSet
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				resultSet = null;
			}
			//PreparedStatement
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				preparedStatement = null;
			}
			//connection
			if(connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				connection = null;
			}
		}
		
		public static void release(PreparedStatement preparedStatement, Connection connection) {
			//preparedStatement
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				preparedStatement = null;
			}
			//connection
			if(connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				connection = null;
			}
		}
}
