package com.yedam.dev.Dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	Connection conn = null;
	public EmpDAO() { // EmpDAO생성자
		String user = "hr";
		String pass = "hr";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void insertEmp(Employee emp) {
		String sql = "insert into emp (employee_id, last_name, email, hire_date, job_id)"
				+"values((select max(employee_id)+1 from emp),"
				+"?, ?, sysdate, ?)"; // last_name, email jobid 순.
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getLastName());
			pstmt.setString(2, emp.getEmail());
			pstmt.setString(3, emp.getJobId());
			int iCnt = pstmt.executeUpdate();
			System.out.println(iCnt + "건 입력.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee>  getEmpList(){
		String sql = "select * from employees";
		List<Employee> list = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id")); // employee_id 값을 가져워서 int 타입으로 바꿔줌		
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setDepartmentId(rs.getInt("department_id"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setSalary(rs.getInt("salary"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setJobId(rs.getString("job_id"));
				list.add(emp);
				
				
					
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	
	}
}
