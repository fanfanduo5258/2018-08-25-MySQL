package com.imooc.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mchange.v2.codegen.bean.PropsToStringGeneratorExtension;

/**
 * JDBC�Ĺ�����
 * @author Administrator
 *
 */
public class JDBCUtils {
		//��ֹд�����峣��
		private static final String driverClass;
		private static final String url;
		private static final String username;
		private static final String password;
		
		//�����ļ������Լ�����
		static {
			//���������ļ���������
			Properties properties = new Properties();
			//��ļ�������ʽ��ȡ�ļ���������
			InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//������������
			try {
				properties.load(inputStream);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			//�������ļ����Ը�ֵ������
			driverClass =properties.getProperty("driverClass");
			url =properties.getProperty("url");
			username =properties.getProperty("username");
			password =properties.getProperty("password");
		}
		
		/**
		 * ע�������ķ���
		 * @throws ClassNotFoundException 
		 */
		public static void loadDriver() throws ClassNotFoundException {
			Class.forName(driverClass);
		}
		
		/**
		 * @throws ClassNotFoundException 
		 * @throws SQLException 
		 * ������ӵķ�����
		 * @throws  
		 */
		public static Connection getConnection() throws Exception {
			//��ȡע�������ķ�����ʵ���ڹ������������ʱ��ֻ�������ӷ���
			loadDriver();
			Connection connection = DriverManager.getConnection(url, username, password);
			return connection;
		}
		
		/**
		 * ��Դ�ͷŵķ���
		 */
		public static void release(ResultSet resultSet, Statement statement, Connection connection) {
			//statement
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				resultSet = null;
			}
			//connection
			if(statement != null) {
				try {
					statement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				statement = null;
			}
		}
		
		public static void release(Statement statement, Connection connection) {
			//statement
			if(statement != null) {
				try {
					statement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				statement = null;
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
		
		public static void release(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
			//statement
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				resultSet = null;
			}
			//connection
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				preparedStatement = null;
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
