package com.imooc.jdbc.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.imooc.jdbc.utils.JDBCUtils;

/**
 * PreparedStatement的使用
 */
public class JDBCDemo5 {
	@Test
	/**
	 * 查询单条数据
	 */
	public void demo5() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		try {
			//获得连接：
			connection = JDBCUtils.getConnection();
			//编写SQL:
			 String sql = "select  * from  user where uid = ?";
			 //预编译SQL：
			 preparedStatement = connection.prepareStatement(sql);
			 //设置参数：
			 preparedStatement.setObject(1, 2);
			 //执行SQL
			 resultSet = preparedStatement.executeQuery();
			 if(resultSet.next()) {
				 System.out.println(resultSet.getInt("uid")+"   "+resultSet.getString("username")+"   "+resultSet.getString("password")+"   "+resultSet.getString("name"));
			 } 
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(resultSet, preparedStatement, connection);;
		}
	}
	
	@Test
	/**
	 * 查询所有数据
	 */
	public void demo4() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		try {
			//获得连接：
			connection = JDBCUtils.getConnection();
			//编写SQL:
			 String sql = "select * from  user";
			 //预编译SQL：
			 preparedStatement = connection.prepareStatement(sql);
			 //执行SQL
			 resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 System.out.println(resultSet.getInt("uid")+"   "+resultSet.getString("username")+"   "+resultSet.getString("password")+"   "+resultSet.getString("name"));
			 }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(resultSet, preparedStatement, connection);;
		}
	}
	
	@Test
	/**
	 * 删除数据
	 */
	public void demo3() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		try {
			//获得连接：
			connection = JDBCUtils.getConnection();
			//编写SQL:
			 String sql = "delete from user where uid = ?";
			 //预编译SQL：
			 preparedStatement = connection.prepareStatement(sql);
			 //设置参数的值
			 preparedStatement.setInt(1, 12); //uid
			 //执行SQL
			 int i = preparedStatement.executeUpdate();
			 if(i>0) {
				 System.out.println("删除成功!");
			 }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(preparedStatement, connection);
		}
	}
	
	@Test
	/**
	 * 修改数据
	 */
	public void demo2() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		try {
			//获得连接：
			connection = JDBCUtils.getConnection();
			//编写SQL:
			 String sql = "update user set username=?, password=?, name=? where uid = ?";
			 //预编译SQL：
			 preparedStatement = connection.prepareStatement(sql);
			 //设置参数的值
			 preparedStatement.setString(1, "www"); //username
			 preparedStatement.setString(2, "123456"); //pasword
			 preparedStatement.setString(3, "张改五"); //name
			 preparedStatement.setInt(4, 10); //uid
			 //执行SQL
			 int i = preparedStatement.executeUpdate();
			 if(i>0) {
				 System.out.println("修改成功!");
			 }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(preparedStatement, connection);
		}
	}
	
	@Test
	/**
	 * 保存数据
	 */
	public void demo1() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		try {
			//获得连接：
			connection = JDBCUtils.getConnection();
			//编写SQL:
			 String sql = "insert into user values (null,?,?,?)";
			 //预编译SQL：
			 preparedStatement = connection.prepareStatement(sql);
			 //设置参数的值
			 preparedStatement.setString(1, "qqq"); //username
			 preparedStatement.setString(2, "123"); //pasword
			 preparedStatement.setString(3, "张五"); //name
			 //执行SQL
			 int i = preparedStatement.executeUpdate();
			 if(i>0) {
				 System.out.println("保存成功!");
			 }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(preparedStatement, connection);
		}
	}
}
