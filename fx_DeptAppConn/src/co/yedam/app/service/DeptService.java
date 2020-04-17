package co.yedam.app.service;

import java.util.List;

import co.yedam.app.model.Departments;

public interface DeptService {
	
	//등록
	boolean insert(Departments dept);

	//수정
	boolean update(Departments dept);

	//삭제
	boolean delete(int dept_id);

	//단건조회
	Departments selectOne(int dept_id);

	//전체조회
	List<Departments> selectAll();
	
}
