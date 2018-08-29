package com.imooc.jdbc.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.imooc.jdbc.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *连接池连接数据库
 */
public class DataSourceCourse {
	/*
	 * 手动配置方式
	 */
	public void demo1() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			//创建连接池：
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			//设置连接池参数
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false");
			dataSource.setUser("root");
			dataSource.setPassword("!Ff52584804");
			dataSource.setMaxPoolSize(20);
			dataSource.setInitialPoolSize(3);		
			//连接池中获得连接
			connection = dataSource.getConnection();
			//编写SQL：
			String sql = "select * from user";
			//预编译SQL
			preparedStatement = connection.prepareStatement(sql);
			//设置参数(没有)
			//执行SQL：
			resultSet = preparedStatement.executeQuery();
			//打印输出数据
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id")+"   "+resultSet.getString("name")+"   "+resultSet.getString("category")+"   "+resultSet.getString("desp")+"   "+resultSet.getString("createTime"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//释放资源
			JDBCUtils.release(connection, preparedStatement, resultSet);
		}
	}
	
	/*
	 * 配置文件方式
	 */
	@Test
	public void demo() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet  resultSet = null;
		try {
			//获得连接
			connection = JDBCUtils.getConnection();
			//编写SQL
			String sql = "select * from course";
			//预编译SQL
			preparedStatement = connection.prepareStatement(sql);
			//设置参数(没有)
			//执行SQL
			resultSet =preparedStatement.executeQuery();
			//打印数据
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
