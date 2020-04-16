package com.yedam.employee;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;



public class EmployeeFilter {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		String path = EmployeeStream.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path, "UTF-8");
		properties.load(new FileReader(path));
		
		String url = properties.getProperty("url");
		String driver = properties.getProperty("driver");
		String user = properties.getProperty("user");
		String pass = properties.getProperty("passwd");
		
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			System.out.println("정상적인 드라이버가 아닙니다.");
		} catch (SQLException e) {
			System.out.println("접속정보를 확인하세요.");

		}
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("select salary, first_name from employees ORDER BY 2");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Employee(rs.getInt("salary"), rs.getString("first_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	      Stream<Employee> stream = list.stream();
	      stream.filter(s -> s.getSalary() >= 1000)
	            .forEach((s) -> System.out.println(s.getFirstName() + ", " + s.getSalary()));
	   }

	}
