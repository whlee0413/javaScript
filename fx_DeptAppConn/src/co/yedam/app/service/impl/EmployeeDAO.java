package co.yedam.app.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.yedam.app.model.Departments;
import co.yedam.app.model.Employee;

public class EmployeeDAO {

	// singletone
	private static EmployeeDAO instance = new EmployeeDAO();

	public static EmployeeDAO getInscance() {
		return instance;
	}
	
	//부서 인원 조회
	public int selectDeptCnt(Connection conn, int dept_id) throws SQLException {
		int cnt = 0;
		// 3. SQL 구문 실행
		String sql = " select count(*) from employees where department_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dept_id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			cnt = rs.getInt(1);
		}
		return cnt;
	}	

	// 등록
	public void insert(Connection conn, Departments dept) throws SQLException {
		String sql = "insert into departments (department_id, department_name, manager_id, location_id)"
				+ "                    values (?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dept.getDepartment_id());
		pstmt.setString(2, dept.getDepartment_name());
		pstmt.setInt(3, dept.getManager_id());
		pstmt.setInt(4, dept.getLocation_id());
		int r = pstmt.executeUpdate();
		System.out.println(r + "건 등록완료");
	}

	// department_name 수정
	public void update(Connection conn, Departments dept) throws SQLException {
		String sql = "update departments set  department_name = ?" + "   where department_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dept.getDepartment_name());
		pstmt.setInt(2, dept.getDepartment_id());
		int r = pstmt.executeUpdate();
		System.out.println(r + "건 수정완료");
	}

	// 삭제
	public void delete(Connection conn, int dept_id) throws SQLException {
		String sql = "delete from departments where department_id = " + dept_id;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int r = pstmt.executeUpdate(sql);
		System.out.println(r + "건 삭제 완료");
	}

	// 단건조회
	public Employee selectOne(Connection conn, int dept_id) throws SQLException {
		Employee dept = null;
		// 3. SQL 구문 실행
		String sql = " select * from departments where department_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dept_id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
		/*	dept = new Departments();
			dept.setDepartment_id(rs.getInt("department_id"));
			dept.setDepartment_name(rs.getString("department_name"));
			dept.setManager_id(rs.getInt("manager_id"));
			dept.setLocation_id(rs.getInt("location_id"));*/
		}
		return dept;
	}

	// 전체조회
	public List<Departments> selectAll(Connection conn) throws SQLException {
		ArrayList<Departments> list = new ArrayList<Departments>();
		Departments dept = null;
		String sql = " select * from departments order by department_id ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(sql);
		while (rs.next()) {
			dept = new Departments();
			dept.setDepartment_id(rs.getInt("department_id"));
			dept.setDepartment_name(rs.getString("department_name"));
			dept.setManager_id(rs.getInt("manager_id"));
			dept.setLocation_id(rs.getInt("location_id"));
			list.add(dept);
		}
		return list;
	}

	// 페이징 조회
	public List<Departments> selectPage(Connection conn, int start, int end) throws SQLException {
		ArrayList<Departments> list = new ArrayList<Departments>();
		Departments dept = null;
			String sql = "select b.*  from ( select rownum rn, a.* from ( "
					+ "   select * from departments order by department_id " + ") a  ) b  where  rn between ? and ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				dept = new Departments();
				dept.setDepartment_id(rs.getInt("first_name"));
				dept.setDepartment_name(rs.getString("last_name"));
				dept.setManager_id(rs.getInt("commission_pct"));
				dept.setLocation_id(rs.getInt("location_id"));
				list.add(dept);
			}
		return list;
	}
}
