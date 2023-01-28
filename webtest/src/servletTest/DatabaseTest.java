package servletTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTest {

 public static void main(String[] args) {
	 try {
		 new DatabaseTest().execute();
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
 }

 public void execute() throws Exception {
	 Connection conn = null;
	 Statement stmt = null;
	 ResultSet rs = null;

	 //魔法（ドライバのロード）
	 Class.forName("oracle.jdbc.driver.OracleDriver");

	 //DBに接続(URL,USER_ID,PASSWORD)
	 conn = DriverManager.getConnection("jdbc:oracle:thin:@oraclelinux7:1521:ORA1", "test", "test");

	 //SQLを発行
	 stmt = conn.createStatement();
	 rs = stmt.executeQuery("select * from test01");

	 //結果を取得
	 while(rs.next()) {
	 System.out.println("結果：" + rs.getString("col01"));
	 }

	 //後始末
	 rs.close();
	 stmt.close();
	 conn.close();
 }

}