package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


	public class MenuDAO {
		
		//DO : data object
		//=VO : value object = DTO : data Transfer
		//DAO : data Access
		String url = "jdbc:oracle:thin:@DESKTOP-JHD2SVO:1521:xe";
		Connection conn = null;
		
		
		//등록 
		public void insert(MenuDO menu) {
			//1.connect(DB연결)

			try {
				conn = DriverManager.getConnection(url, "hr", "hr"); //빼야 다른 곳에서도 사용할 수있기때문에 try안은 conn으로 변수를 준다
			//2.statement(SQL 구문 준비)
				String sql = "insert into menu (type,name) "
						+ "values(?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
			//3.execute
			pstmt.setString(1, menu.getType());
			pstmt.setString(2, menu.getName());
			pstmt.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("주소 또는 아이디와 패스워드를 확인하세요");
				e.printStackTrace();
			} finally {
//				5.close(연결해제)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//4.조회결과(현재 필요없음)
			
			
		}

		//삭제
		
		public void delete(MenuDO menu) {
			//1.connect(DB연결)

			try {
				conn = DriverManager.getConnection(url, "hr", "hr"); //빼야 다른 곳에서도 사용할 수있기때문에 try안은 conn으로 변수를 준다
			//2.statement(SQL 구문 준비)
				String sql = "delete from menu where name= ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
			//3.execute
			pstmt.setString(1, menu.getName());
			pstmt.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("주소 또는 아이디와 패스워드를 확인하세요");
				e.printStackTrace();
			} finally {
				//5.close(연결해제)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
			
			//4.결과 처리
			if(rs.next()) { //next 행의 이동
				MenuDO.setType(rs.getString("type"));
				MenuDO.setName(rs.getString("name"));
			}
			
			} catch (SQLException e) {
				System.out.println("주소 또는 아이디와 패스워드를 확인하세요");
				e.printStackTrace();
			} finally {
			}
			return menuDO;
	}
	
	
		  //Random
		   public MenuDO random(MenuDO menu) { // 조회는 return값이 있어야함. void x

		         MenuDO menuDO = new MenuDO();
		         try {
		            //1. connect(DB 연결)
		            conn = DriverManager.getConnection(url, "hr", "hr");
		            //2. statement(SQL 구문 준비)
		            String sql = "select * from  (select * from menu order by dbms_random.value) "
		            			+ "where rownum =1;";
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		            
		            //3. execute
		            pstmt.setString(1, menu.getName());
		            ResultSet rs = pstmt.executeQuery();

		            //4. 결과처리
		            //조회된 결과를 EmpDo에 담으면 됨.
		            if(rs.next()) { // 없는 값 조회를 피하기 위해서 if(rs.next())
		               menuDO.setName(rs.getString("name"));
		               
		               
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
}//end of class
