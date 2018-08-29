package com.imooc.jdbc.demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.imooc.jdbc.utils.JDBCUtils;
import com.imooc.jdbc.utils.JDBCUtils2;
import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 连接池的测试类
 * @author Administrator
 *
 */
public class DataSourceDemo1 {
	@Test
	/**
	 * 使用配置文件的方式
	 */
	public void demo2() {
		//获得连接：
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//获得连接：
			connection = JDBCUtils2.getConnection();
			//编写SQL:
			String sql = "select * from user";
			//预编译SQL:
			preparedStatement = connection.prepareStatement(sql);
			//设置参数(没有)
			//执行SQL：
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
	 * 手动设置连接池
	 */
	public void demo1() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//获得连接：
			//创建连接池:
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			//设置连接池的参数：
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
			dataSource.setUser("root");
			dataSource.setPassword("!Ff52584804");
			dataSource.setMaxPoolSize(20); //最大连接数
			dataSource.setInitialPoolSize(3); //初始化连接数
			
			//连接池中获得连接
			connection = dataSource.getConnection();
			//编写SQL:
			String sql = "select * from user";
			//预编译SQL:
			preparedStatement = connection.prepareStatement(sql);
			//设置参数(没有)
			//执行SQL：
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
