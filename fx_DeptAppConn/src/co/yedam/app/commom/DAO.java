package co.yedam.app.commom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

	static {
		try {
			// 1. oracle 드라이버 로딩
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//1. sqlite 드라이버 로딩
			Class.forName("org.sqlite.JDBC");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public final static String DATABASE = "insa.db";


	public static Connection connect() {
		Connection conn = null;
		try {
			

			// 2. DB 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			//connection pool에서 connection을 할당
			/*Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/oracle");
			conn = ds.getConnection();
			if(conn != null) {
				System.out.println("연결 성공");
			}*/

			/*
			 * SQLiteConfig config = new SQLiteConfig(); config.setReadOnly(true);
			 */
			//conn =  DriverManager.getConnection("jdbc:sqlite:/" + DAO.DATABASE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void disconnect(Connection conn) {
		if (conn != null)
			try {
				// 5. 연결 종료
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
