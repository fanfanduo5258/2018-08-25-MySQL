package com.imooc.jdbc.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo1 {
	
	@Test
	/**
	 * JDBC资源的释放
	 */
	public void demo2() {
		//为了释放资源将MySQL对象定义在try外
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			//1.加载驱动
//			DriverManager.registerDriver(new Driver()); //会导致驱动注册两次
			Class.forName("com.mysql.jdbc.Driver"); //
			
			//2.获得连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8", "root","!Ff52584804");
			
			//3.创建执行SQL语句的对象，并且执行SQL
			//3.1 创建执行sql的对象
			String sql = "select * from user";
			statement = conn.createStatement();

			//3.2 执行sql
			resultSet = statement.executeQuery(sql);
			//3.3 循环出MySQL中的数据
			while(resultSet.next()) {
				int uid = resultSet.getInt("uid");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				
				System.out.println(uid+"      "+username+"      "+password+"      "+name);
			}
			

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//4.释放资源
			//4.1 resultSet释放
			if(resultSet != null) {
				try {
					resultSet.close();
				}
				catch(SQLException e) {
					resultSet = null; //垃圾回收机制
				}
			}
			//4.2 statement释放
			if(statement != null) {
				try {
					statement.close();
				} 
				catch (SQLException e) {
					statement = null; //垃圾回收机制
				}
			}
			//4.3 conn释放
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					conn = null; //垃圾回收机制
				}
			}
		}
	}
}


