package servletTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//コンテキストファイルのデータソースを使用してDBにアクセス

public class DatabaseSrTest extends HttpServlet {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<String> result = new ArrayList<>();
	Logger logger;

	//コンストラクタ
	public DatabaseSrTest() throws NamingException, SQLException {

		//ロガーの呼び出し
		logger = LogManager.getLogger();

		//DBに接続
		InitialContext ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/test");
		conn = ds.getConnection();
	}

	//select
	 public ArrayList<String> select(String sql,String colname) {
		 try {
			//SQLを発行
			pstmt = conn.prepareStatement(sql);
			//pstmt.clearParameters();
			//pstmt.setString(1, "X");
			rs = pstmt.executeQuery();
			logger.info("###########");
			logger.info("SQL:{}", sql);
			//結果を取得
			while(rs.next()) {
				result.add(rs.getString(colname));
				logger.info("result:{}", rs.getString(colname));
			}
			logger.info("###########");
			//後始末
			rs.close();
			pstmt.close();
			conn.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	 //insert update delete
	 public void iud(String sql) {
		 try {
			//SQLを発行
			pstmt = conn.prepareStatement(sql);
			//pstmt.clearParameters();
			//pstmt.setString(1, "X");
			rs = pstmt.executeQuery();

			//後始末
			rs.close();
			pstmt.close();
			conn.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}