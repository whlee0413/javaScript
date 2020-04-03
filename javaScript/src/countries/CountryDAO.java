package countries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.board.Board;

public class CountryDAO {
	Connection conn = null;

	public CountryDAO() {
		String user = "hr";
		String pass = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public List<Country> getCountryList() {
		String sql = "select * from countries order by 1 desc";
		List<Country> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Country con = new Country();
				con.setCountryId(rs.getString("country_id"));
				con.setCountryName(rs.getString("country_name"));
				con.setRegionId(rs.getInt("region_id"));
				

				list.add(con);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	

}
