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
		//���Զ���
		Demo d = new Demo();
		//�������ݿ������������
		d.createDb();
		//SQL����Map
		Map param = new HashMap();
		param.put("id", 5);
		param.put("name", "amy");
		param.put("password", "123456");
		//�����ݿ��������
		d.insert(param);
		//���MySQL����
		d.getAll();
		//�ͷ���Դ	
		d.close();
	}
	
	/**
	 * �������ݿ�ķ���
	 */
	public void createDb() {
		String  url="jdbc:mysql://localhost:3306/test1?useUnicode=true&characterEncoding=utf8";
		String name="com.mysql.jdbc.Driver";
		String user="root";
		String password="root";
		try {
			//��������
			Class.forName(name);
			//�������
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * �������ݵ�MySQL�ķ���
	 * @param param ��Ҫ�������ݵ�Map
	 * @return ִ��SQL��������Ľ��
	 */
	public int insert(Map param) {
		//���ô������ݿⷽ��
//		this.createDb();
		//���ؽ������
		int i=0;
		//��дSQL���
		String sql="INSERT INTO user(id,username,password) VALUES(?,?,?)";
		PreparedStatement pstmt;
		try {
			//Ԥ����SQL
			pstmt = this.connection.prepareStatement(sql);
			//�������������ݿ�
			pstmt.setString(1, (String) param.get("id"));
			pstmt.setString(2, (String) param.get("name"));
			pstmt.setString(3, (String) param.get("password"));
			//ִ��SQL
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//���ؽ��
		return i;
	}
	
	/**
	 * ��ѯMySQL���ݿ�ķ���
	 */
	public void getAll() {
		//��дSQL���
		String sql="select * from user";
		PreparedStatement  prepareStatement = null;
		try {
			//Ԥ����SQL���
			prepareStatement = this.connection.prepareStatement(sql);
			//ִ��SQL
			ResultSet resultSet = prepareStatement.executeQuery();
			//����resultSet�����е�����
			int columnCount = resultSet.getMetaData().getColumnCount();
			System.out.println("=============================");
			//ѭ��������
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
