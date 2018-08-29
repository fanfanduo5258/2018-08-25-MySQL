package com.imooc.jdbc.utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * JDBC的工具类
 * @author Administrator
 *
 */
public class JDBCUtils2 {	
		private  static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
		/**
		 * 获得连接的方法
		 */
		public static Connection getConnection() throws Exception {
			//获取注册驱动的方法，实现在工具类以外调用时，只调用连接方法
			Connection connection = dataSource.getConnection();
			return connection;
		}
		
		/**
		 * 资源释放的方法
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
