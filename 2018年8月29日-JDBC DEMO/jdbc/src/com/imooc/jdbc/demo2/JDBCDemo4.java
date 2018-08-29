package com.imooc.jdbc.demo2;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.imooc.jdbc.utils.JDBCUtils;


public class JDBCDemo4{
	@Test
	/**
	 * 测试SQL注入漏洞的方法
	 */
	public void demo1() {
		//调用本类的login方法，传入用户名和密码，判断数据库中是否有该数据
		boolean flag = JDBCDemo4.login2("aaa","123");
		if(flag==true) {
			System.out.println("登录成功!");
		}
		else {
			System.out.println("登录失败!");
		}
	}
	
	/**
	 * 登录时数据库验证账号密码的方法
	 * 避免SQL注入漏洞的方法
	 */
	public static boolean login2(String username, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean flag = false;
		try {
			//获得连接:
			connection = JDBCUtils.getConnection();
			//编写SQL: ?为占位符
			String sql = "select * from user where username = ? and password = ?";
			//预处理SQL：
			preparedStatement = connection.prepareStatement(sql);
			//设置参数:参数1为第几个?的位置，参数2为值
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			//执行SQL：
			resultSet = preparedStatement.executeQuery();
			//判断结果集
			if(resultSet.next()) {
				flag = true;
			}
			else {
				flag = false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(resultSet, preparedStatement, connection);
		}
		return flag;
	}
	
	/**
	 * 登录时数据库验证账号密码的方法
	 * 该登录方法会产生SQL注入漏洞
	 */
	public static boolean login(String username, String password) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		boolean flag = false;
		try {
			//获得连接
			connection = JDBCUtils.getConnection();
			//创建执行SQL语句的对象
			statement = connection.createStatement();
			//编写SQL：
			String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
			//执行SQL：
			resultSet = statement.executeQuery(sql);
			//判断结果集中是否有数据
			if(resultSet.next()) {
				flag = true;
			}
			else {
				flag = false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtils.release(resultSet, statement, connection);
		}
		return flag;
	}
}

