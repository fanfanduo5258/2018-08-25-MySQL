package com.db.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Demo {
	Connection  connection = null;
	
	public static void main(String[] args) {
		//测试对象
		Demo d = new Demo();
		//创建数据库驱动获得连接
		d.createDb();
		//SQL参数Map
		Map param = new HashMap();
		param.put("id", 5);
		param.put("name", "amy");
		param.put("password", "123456");
		//向数据库插入数据
		d.insert(param);
		//获得MySQL数据
		d.getAll();
		//释放资源	
		d.close();
	}
	
	/**
	 * 创建数据库的方法
	 */
	public void createDb() {
		String  url="jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=utf8";
		String name="com.mysql.jdbc.Driver";
		String user="root";
		String password="root";
		try {
			//创建驱动
			Class.forName(name);
			//获得连接
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 插入数据到MySQL的方法
	 * @param param 需要插入数据的Map
	 * @return 执行SQL插入操作的结果
	 */
	public int insert(Map param) {
		//调用创建数据库方法
//		this.createDb();
		//返回结果变量
		int i=0;
		//编写SQL语句
		String sql="INSERT INTO user(id,username,password) VALUES(?,?,?)";
		PreparedStatement pstmt;
		try {
			//预编译SQL
			pstmt = this.connection.prepareStatement(sql);
			//参数数据至数据库
			pstmt.setString(1, (String) param.get("id"));
			pstmt.setString(2, (String) param.get("name"));
			pstmt.setString(3, (String) param.get("password"));
			//执行SQL
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//返回结果
		return i;
	}
	
	/**
	 * 查询MySQL数据库的方法
	 */
	public void getAll() {
		//编写SQL语句
		String sql="select * from user";
		PreparedStatement  prepareStatement = null;
		try {
			//预编译SQL语句
			prepareStatement = this.connection.prepareStatement(sql);
			//执行SQL
			ResultSet resultSet = prepareStatement.executeQuery();
			//返回resultSet对象中的列数
			int columnCount = resultSet.getMetaData().getColumnCount();
			System.out.println("=============================");
			//循环输出结果
			while(resultSet.next()) {
				for(int i=1;i<=columnCount;i++){
					System.out.print(resultSet.getString(i)+"\t");
					if((i==2)&&(resultSet.getString(i).length()<8)) {
						System.out.print("\t");
					}
				}
				System.out.println("");
			}
			System.out.println("=============================");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
