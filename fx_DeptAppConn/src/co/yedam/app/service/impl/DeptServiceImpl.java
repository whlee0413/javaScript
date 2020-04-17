package co.yedam.app.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import co.yedam.app.commom.DAO;
import co.yedam.app.model.Departments;
import co.yedam.app.model.DepartmentsTable;
import co.yedam.app.model.Employee;
import co.yedam.app.model.Location;
import co.yedam.app.service.DeptService;

public class DeptServiceImpl implements DeptService{

	DeptDAO deptDAO = DeptDAO.getInscance();
	EmployeeDAO empDAO = EmployeeDAO.getInscance();
	LocationDAO locationDAO = LocationDAO.getInscance();
	
	//singletone
	private static DeptServiceImpl  instance = new DeptServiceImpl();
	public static DeptServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public boolean insert(Departments dept) {
		Connection conn = DAO.connect();
		try {
			conn.setAutoCommit(false);
			//부서가 있는지 확인
			Departments deptResult = deptDAO.selectOne(conn, dept.getDepartment_id());
			if(deptResult != null) {
				System.out.println("이미 있는 부서입니다.");
				return false;
			}
			
			//메니저가 있는지 확인
			Employee emp = empDAO.selectOne(conn, dept.getManager_id());
			if(emp == null) {
				System.out.println("없는 사원입니다.");
				return false;
			} 
			
			//지역번호가 맞는지 확인
			Location location = locationDAO.selectOne(conn, dept.getLocation_id());
			if(location == null) {
				System.out.println("없는 지역입니다.");
				return false;
			}
			
			//부서 등록
			deptDAO.insert(conn, dept);
			
			//커밋
			conn.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			//롤백
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DAO.disconnect(conn);
		}
		return true;		
	}

	@Override
	public boolean update(Departments dept) {
		Connection conn = DAO.connect();
		try {
			conn.setAutoCommit(false);
			
			//부서가 있는지 확인
			Departments resultDept = deptDAO.selectOne(conn, dept.getDepartment_id());
			if(resultDept == null) {
				System.out.println("없는부서입니다.");
				return false;
			}
			
			//부서원이 있는지 확인
			int cnt = empDAO.selectDeptCnt(conn, dept.getDepartment_id());
			if(cnt > 0 ) {
				System.out.println("부서에 배정된 사원이 있습니다.");
				return false;
			} 
			
			//부서 수정
			deptDAO.update(conn, dept);
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DAO.disconnect(conn);
		}
		return true;
		
	}

	@Override
	public boolean delete(int dept_id) {
		Connection conn = DAO.connect();
		try {
			//부서가 있는지 확인
			Departments dept = deptDAO.selectOne(conn, dept_id);
			if(dept == null) {
				System.out.println("없는부서입니다.");
				return false;
			}
			
			//부서원이 있는지 확인
			int cnt = empDAO.selectDeptCnt(conn, dept_id);
			if(cnt > 0 ) {
				System.out.println("부서에 배정된 사원이 있습니다.");
				return false;
			} 
			
			//부서 삭제
			deptDAO.delete(conn, dept_id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DAO.disconnect(conn);
		}
		return true;
	}

	@Override
	public Departments selectOne(int dept_id) {
		Connection conn = DAO.connect();
		try {
			return deptDAO.selectOne(conn, dept_id);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DAO.disconnect(conn);
		}
	}

	@Override
	public List<Departments> selectAll() {
		Connection conn = DAO.connect();
		List<Departments> list = null;
		try {
			list = deptDAO.selectAll(conn);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DAO.disconnect(conn);
		}
		return list;
	}
	
	public List<DepartmentsTable> selectAllTable() {
		Connection conn = DAO.connect();
		List<DepartmentsTable> list = null;
		try {
			list = deptDAO.selectAllTable(conn);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DAO.disconnect(conn);
		}
		return list;
	}
}
