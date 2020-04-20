package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuDAO {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = null; // 다른 블럭에서도 connection 쓰기위해서 try밖에서  변수선언
	// 위의 두 변수는 모든 method에서  공통으로 쓰기 위한 변수라서 filed로 꺼냄
	
	
	//동록
	public void insert(MenuDO menu) {
		//1. connect(DB 연결)
		try {
			conn = DriverManager.getConnection(url, "hr", "hr");
			//2. statement(SQL 구문 준비)
			String sql = "insert into menu (food_name, food_type)"
					+ "values (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3. execute
			pstmt.setString(1, menu.getFoodName());
			pstmt.setString(2, menu.getFoodKind());
			
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
	
	//삭제
	public void delete(MenuDO menu) {
		//1. connect(DB 연결)
		try {
			conn = DriverManager.getConnection(url, "hr", "hr");
			//2. statement(SQL 구문 준비)
			String sql = "delete from menu  where food_name=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3. execute
			pstmt.setString(1, menu.getFoodName());
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
	public MenuDO selectOne(MenuDO menu) { // 조회는 return값이 있어야함. void x

		MenuDO menuDO = new MenuDO();
		try {
			//1. connect(DB 연결)
			conn = DriverManager.getConnection(url, "hr", "hr");
			//2. statement(SQL 구문 준비)
			String sql = "select * from menu  where food_name=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3. execute
			pstmt.setString(1, menu.getFoodName());
			ResultSet rs = pstmt.executeQuery();

			//4. 결과처리
			//조회된 결과를 EmpDo에 담으면 됨.
			if(rs.next()) { // 없는 값 조회를 피하기 위해서 if(rs.next())
				menuDO.setFoodName(rs.getString("food_name"));
				menuDO.setFoodKind(rs.getString("food_type"));
				
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
		return menuDO;
	}
	
	//w전체조회
	public ArrayList<MenuDO> selectAll() { // 조회는 return값이 있어야함. void x
		ArrayList<MenuDO> list = new ArrayList<MenuDO>();
		try {
			//1. connect(DB 연결)
			conn = DriverManager.getConnection(url, "hr", "hr");
			//2. statement(SQL 구문 준비)
			String sql = "select * from menu  order by food_name";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3. execute
			ResultSet rs = pstmt.executeQuery();

			//4. 결과처리
			//조회된 결과를 EmpDo에 담으면 됨.
			while(rs.next()) { 
				MenuDO menuDO = new MenuDO();
				menuDO.setFoodName(rs.getString("food_name"));
				menuDO.setFoodKind(rs.getString("food_type"));
				list.add(menuDO);
				
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
		return list;
	}
	
	//랜덤
	public MenuDO random(MenuDO men) { // 조회는 return값이 있어야함. void x

        MenuDO menuDO = new MenuDO();
        try {
           //1. connect(DB 연결)
           conn = DriverManager.getConnection(url, "hr", "hr");
           //2. statement(SQL 구문 준비)
           String sql = "select * from  (select * from menu where food_type = ? order by dbms_random.value) where rownum =1;";
           PreparedStatement pstmt = conn.prepareStatement(sql);
           
           //3. execute
           pstmt.setString(1, men.getFoodKind());
           ResultSet rs = pstmt.executeQuery();

           //4. 결과처리
           //조회된 결과를 EmpDo에 담으면 됨.
           if(rs.next()) { // 없는 값 조회를 피하기 위해서 if(rs.next())
              menuDO.setFoodName(rs.getString("food_name"));
              menuDO.setFoodKind(rs.getString("food_type"));
              
              
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
        return menuDO;
     }
	
	
}
