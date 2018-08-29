package com.imooc.jdbc.demo1;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;

import com.imooc.jdbc.utils.JDBCUtils;

public class JDBCDemo3 {
		/**
		 * �����¼
		 */
		@Test
		public void demo1() {
			Connection connection = null;
			Statement statement = null;
			try {
				//������ӣ�
				connection = JDBCUtils.getConnection();
				// ����ִ��SQL���Ķ���
				statement = connection.createStatement();
				//��дSQL
				String sql = "insert into user values(null,'jjj','123','С��')";
				//ִ��SQL
				int i = statement.executeUpdate(sql);
				//�ж������Ƿ����0
				if(i>0) {
					System.out.println("����ɹ�");
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				//�ͷ���Դ
				JDBCUtils.release(statement, connection);
			}
		}
}
