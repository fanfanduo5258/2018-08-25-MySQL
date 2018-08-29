package com.imooc.jdbc.demo1;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;

import com.imooc.jdbc.utils.JDBCUtils;

public class JDBCDemo3 {
		/**
		 * 保存记录
		 */
		@Test
		public void demo1() {
			Connection connection = null;
			Statement statement = null;
			try {
				//获得连接：
				connection = JDBCUtils.getConnection();
				// 创建执行SQL语句的对象
				statement = connection.createStatement();
				//编写SQL
				String sql = "insert into user values(null,'jjj','123','小六')";
				//执行SQL
				int i = statement.executeUpdate(sql);
				//判断行数是否大于0
				if(i>0) {
					System.out.println("保存成功");
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				//释放资源
				JDBCUtils.release(statement, connection);
			}
		}
}
