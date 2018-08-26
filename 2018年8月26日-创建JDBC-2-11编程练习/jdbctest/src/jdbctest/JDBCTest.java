package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class JDBCTest {
	
	@Test
	public void demo1() {
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.获得链接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8", "root", "!Ff52584804");
			
			//3.创建执行SQL的对象，并且执行SQL
			//3.1创建
			String sql="SELECT * FROM user1 WHERE price<=3500";
			Statement statement = conn.createStatement();
			//3.2执行
			ResultSet resultSet = statement.executeQuery(sql);
			//3.3 循环出MySQL中的数据
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				float price = resultSet.getFloat("price");
				String desp = resultSet.getString("desp");
				
				System.out.println(id+"      "+name+"      "+price+"      "+desp);
			}
			
			//4.释放资源
			resultSet.close();
			statement.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
