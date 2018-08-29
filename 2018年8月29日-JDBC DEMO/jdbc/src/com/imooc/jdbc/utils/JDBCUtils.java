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
 * JDBC的工具类
 * @author Administrator
 *
 */
public class JDBCUtils {
		//防止写死定义常量
		private static final String driverClass;
		private static final String url;
		private static final String username;
		private static final String password;
		
		//配置文件解析以及配置
		static {
			//加载属性文件并解析：
			Properties properties = new Properties();
			//类的加载器方式获取文件的输入流
			InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//将输入流传入
			try {
				properties.load(inputStream);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			//将配置文件属性赋值给常量
			driverClass =properties.getProperty("driverClass");
			url =properties.getProperty("url");
			username =properties.getProperty("username");
			password =properties.getProperty("password");
		}
		
		/**
		 * 注册驱动的方法
		 * @throws ClassNotFoundException 
		 */
		public static void loadDriver() throws ClassNotFoundException {
			Class.forName(driverClass);
		}
		
		/**
		 * @throws ClassNotFoundException 
		 * @throws SQLException 
		 * 获得连接的方法：
		 * @throws  
		 */
		public static Connection getConnection() throws Exception {
			//获取注册驱动的方法，实现在工具类以外调用时，只调用连接方法
			loadDriver();
			Connection connection = DriverManager.getConnection(url, username, password);
			return connection;
		}
		
		/**
		 * 资源释放的方法
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
