package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuDAO {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = null; // 다른 블럭에서도 connection 쓰기위해서 try밖에서  변수선언
	// 위의 두 변수는 모든 method에서  공통으로 쓰기 위한 변수라서 filed로 꺼냄
	
	
	//동록
	public void insert(EmpDO emp) {
		//1. connect(DB 연결)
		try {
			conn = DriverManager.getConnection(url, "hr", "hr");
			//2. statement(SQL 구문 준비)
			String sql = "insert into employees (employee_id, last_name, email, hire_date, job_id)"
					+ "values (?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3. execute
			pstmt.setString(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getHireDate());
			pstmt.setString(5, emp.getJobId());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. close(연결해제)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	//수정
	
	//조회
	
	//삭제
	public void delete(EmpDO emp) {
		//1. connect(DB 연결)
		try {
			conn = DriverManager.getConnection(url, "hr", "hr");
			//2. statement(SQL 구문 준비)
			String sql = "delete from employees  where employee_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3. execute
			pstmt.setString(1, emp.getEmployeeId());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. close(연결해제)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	//단건조회
	public EmpDO selectOne(EmpDO emp) { // 조회는 return값이 있어야함. void x

		EmpDO empDO = new EmpDO();
		try {
			//1. connect(DB 연결)
			conn = DriverManager.getConnection(url, "hr", "hr");
			//2. statement(SQL 구문 준비)
			String sql = "select * from employees  where employee_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3. execute
			pstmt.setString(1, emp.getEmployeeId());
			ResultSet rs = pstmt.executeQuery();

			//4. 결과처리
			//조회된 결과를 EmpDo에 담으면 됨.
			if(rs.next()) { // 없는 값 조회를 피하기 위해서 if(rs.next())
				empDO.setEmployeeId(rs.getString("EMPLOYEE_ID"));
				empDO.setLastName(rs.getString("last_name"));
				empDO.setJobId(rs.getString("job_id"));
				empDO.setEmail(rs.getString("email"));
				empDO.setHireDate(rs.getString("hire_date"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. close(연결해제)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empDO;
	}
	
}
