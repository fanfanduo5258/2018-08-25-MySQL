package com.imooc.jdbc.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo2 {
	@Test
	/**
	 * 查询一条记录
	 */
	public void demo5() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			//注册驱动：
			Class.forName("com.mysql.jdbc.Driver");
			//获得连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8", "root", "!Ff52584804");
			//创建执行SQL语句的对象
			statement = connection.createStatement();
			//编写SQL：
			String sql = "SELECT * FROM user WHERE uid=2";
			//执行SQL：
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				System.out.println(resultSet.getInt("uid")+"     "+resultSet.getString("username")+"     "+resultSet.getString("password")+"     "+resultSet.getString("name"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//释放资源
			//connection
			if(connection != null) {
				try {
					connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				connection = null;
			}
			//statement
			if(statement != null) {
				try {
					statement.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null;
			}	
			//resultSet
			if(resultSet != null) {
				try {
					resultSet.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				resultSet = null;
			}	
		}
	}
	
	@Test
	/**
	 * 查询所有记录
	 */
	public void demo4() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			//注册驱动：
			Class.forName("com.mysql.jdbc.Driver");
			//获得连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8", "root", "!Ff52584804");
			//创建执行SQL语句的对象
			statement = connection.createStatement();
			//编写SQL：
			String sql = "SELECT * FROM user";
			//执行SQL：
			resultSet = statement.executeQuery(sql);
			//遍历结果集：
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("uid")+"     "+resultSet.getString("username")+"     "+resultSet.getString("password")+"     "+resultSet.getString("name"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//释放资源
			//connection
			if(connection != null) {
				try {
					connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				connection = null;
			}
			//statement
			if(statement != null) {
				try {
					statement.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null;
			}	
			//resultSet
			if(resultSet != null) {
				try {
					resultSet.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				resultSet = null;
			}	
		}
	}
	
	@Test
	/**
	 * 删除操作
	 */
	public void demo3() {
		Connection connection = null;
		Statement statement = null;
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获得连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8", "root", "!Ff52584804");
			//创建执行SQL语句的对象
			statement = connection.createStatement();
			//编写SQL：
			String sql = "delete from user where uid=4";
			//执行SQL：
			int i = statement.executeUpdate(sql);
			//判断行数是否大于0
			if(i>0) {
				System.out.println("删除成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//释放资源：
			//connection
			if(connection != null) {
				try {
					connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				connection = null;
			}
			//statement
			if(statement != null) {
				try {
					statement.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null;
			}	
		}
	}
	
	@Test
	/**
	 * 修改操作
	 */
	public void demo2() {
		Connection connection = null;
		Statement statement = null;
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获得连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8", "root", "!Ff52584804");
			//创建执行SQL语句的对象
			statement = connection.createStatement();
			//编写SQL：
			String sql = "update user set username = 'qqq', password='456', name='赵六' where uid=4";
			//执行SQL：
			int i = statement.executeUpdate(sql);
			//判断行数是否大于0
			if(i>0) {
				System.out.println("修改成功！");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//释放资源：
			//connection
			if(connection != null) {
				try {
					connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				connection = null;
			}
			//statement
			if(statement != null) {
				try {
					statement.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null;
			}	
		}
	}
	
	
	@Test
	/**
	 * 保存操作
	 */
	public void demo1() {
		Connection connection = null;
		Statement statement = null;
		try {
			//注册驱动：
			Class.forName("com.mysql.jdbc.Driver");
			//获得链接：
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8", "root", "!Ff52584804");
			//获得执行SQL语句的对象：
			statement = connection.createStatement();
			//编写SQL：
			String sql = "insert into user values(null,'eee','123','张三')";
			//执行SQL：
			int i = statement.executeUpdate(sql);
			//判定是否有行数
			if(i>0) {
				System.out.println("保存成功!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//释放资源：
			//connection
			if(connection != null) {
				try {
					connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				connection = null;
			}
			//statement
			if(statement != null) {
				try {
					statement.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				statement = null;
			}		
		}
	}
}
