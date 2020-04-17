package com.yedam.lunch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Menu {
	private String food;

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}
	


}

public class Lunch {

	static List<Menu> list = new ArrayList<>();

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			} catch (SQLException e) {
				System.out.println("오라클과 연결에 실패하였습니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수업습니다");
		}
		return conn;
	}

	public static void inputEmp(Menu men) {
		Connection con = getConnection();
		String sql = "insert into emps values(?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, men.getFood());
			
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteMen(String menu) {
		Connection con = getConnection();
		String sql = "delete from emps where first_name =?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, menu);
			pstmt.executeUpdate();
			System.out.println("삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	

	public static List<Menu> getEmpList() {
		Connection con = getConnection();
		String sql = "select first_name, salary from emps";
		List<Menu> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Menu());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
      return list;
//		return null;
	}

	public static void main(String[] args) {
		Menu men = new Menu();
		list.add(men);

		Scanner scn = new Scanner(System.in);
		int menu;
		while (true) {
			System.out.println("1:입력 2:출력 3:삭제(이름) 4:종료");
			menu = scn.nextInt();
			scn.nextLine();

			if (menu == 1) {
				System.out.println("이름입력: ");
				String name = scn.nextLine();
				System.out.println("연봉입력: ");
				int salary = scn.nextInt();
				Menu Menu = new Menu();
				inputEmp(Menu); // 한건 입력 처리.

			} else if (menu == 2) {
				List<Menu> returnList = getEmpList();
				double num = Math.random()*5;
				
				
				for (Menu emps : returnList)
					System.out.println(emps.getFirstName()+ ", " +emps.getSalary());
					System.out.println(returnList.get((int) num).getFirstName());
			} else if (menu == 3) {
				System.out.println("삭제할 이름을 입력하세요.");
				String name = scn.nextLine();
				deleteEmp(name);
				
			}  else if(menu==4) {
				System.out.println("종료되었습니다.");
				break;
			}
			
		}
	}
}