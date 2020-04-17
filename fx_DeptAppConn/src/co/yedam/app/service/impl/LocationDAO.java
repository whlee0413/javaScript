package co.yedam.app.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.yedam.app.model.Location;

public class LocationDAO {

	// singletone
	private static LocationDAO instance = new LocationDAO();

	public static LocationDAO getInscance() {
		return instance;
	}

	// 단건조회
	public Location selectOne(Connection conn, int location_id) throws SQLException {
		Location location = null;
		// 3. SQL 구문 실행
		String sql = " select * from locations where location_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			location = new Location();
			location.setLocation_id(rs.getString("location_id"));
			location.setCity(rs.getString("city"));
		}
		return location;
	}

	// 전체조회
	public List<Location> selectAll(Connection conn) throws SQLException {
		ArrayList<Location> list = new ArrayList<Location>();
		Location location = null;
		String sql = " select * from Locations order by city ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		while (rs.next()) {
			location = new Location();
			location.setLocation_id(rs.getString("location_id"));
			location.setCity(rs.getString("city"));
			list.add(location);
		}
		return list;
	}

}
