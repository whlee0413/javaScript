package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
	private String firstName;
	private int salary;

	public Employee() {
	}

	public Employee(String firstName, int salary) {
		super();
		this.firstName = firstName;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}

public class ScannerExample {

	static List<Employee> list = new ArrayList<>();

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

	public static void inputEmp(Employee emp) {
		Connection con = getConnection();
		String sql = "insert into emps values(?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emp.getFirstName());
			pstmt.setInt(2, emp.getSalary());
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
		// list.add(emp);
	}
	
	public static void deleteEmp(String name) {
		Connection con = getConnection();
		String sql = "delete from emps where first_name =?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			System.out.println("삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	

	public static List<Employee> getEmpList() {
		Connection con = getConnection();
		String sql = "select first_name, salary from emps";
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Employee(rs.getString("first_name"),rs.getInt("salary")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
      return list;
//		return null;
	}

	public static void main(String[] args) {
		Employee emp = new Employee("Hwang", 1000);
		list.add(emp);
		list.add(new Employee("Hwang", 2000));

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
				Employee emps = new Employee(name, salary);
				inputEmp(emps); // 한건 입력 처리.

			} else if (menu == 2) {
				List<Employee> returnList = getEmpList();

				for (Employee emps : returnList)
					System.out.println(emps.getFirstName()+ ", " +emps.getSalary());

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