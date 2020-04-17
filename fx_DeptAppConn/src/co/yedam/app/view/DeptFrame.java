package co.yedam.app.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import co.yedam.app.model.Departments;
import co.yedam.app.model.Menu;
import co.yedam.app.service.impl.DeptServiceImpl;



public class DeptFrame {

	Scanner scanner = new Scanner(System.in);
	DeptServiceImpl deptService = new DeptServiceImpl();

	// 생성자
	public DeptFrame() {
		
		boolean roop = true;
		
		while (roop) {			
			//메뉴출력
			menuPrint();
			
			//메뉴선택
			Menu menuNo = menuSelect();
			
			//메뉴별 실행
			switch(menuNo) {
				case INSERT : insertDept(); break;
				case DELETE : updateDept(); break;
				case UPDATE : deleteDept(); break;
				case SEARCH : selectOne(); break;
				case SELECT : selectAll(); break;
				case EXIT   : end(); 
				              roop = false; 
			}
			
		}
	}

	// 프로그램 종료
	void end() {
		System.out.println("프로그램 종료합니다.");
	}

	// 메뉴출력
	void menuPrint() {
		System.out.println("");
		System.out.println("=========================================");
		System.out.println("1.등록   2.수정  3.삭제  4.부서조회  5.부서전체조회  9.종료");
		System.out.println("=========================================");
	}

	// 메뉴번호 입력
	Menu menuSelect() {
		
		Menu menuNo = null;
		boolean loop = true;	
		
		while (loop) {		
			try {
				System.out.print("선택>> ");
				menuNo = Menu.valueOf(scanner.nextInt());
				
				if (menuNo == null) {
					System.out.println("없는 메뉴입니다!");
				} else {
					loop = false;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("숫자만 입력");
				scanner.next();
			}
		}
		return menuNo;
	}

	// 부서등록
	void insertDept() {
		Departments dept = inputAll();
		deptService.insert(dept);
	}

	// 부서수정
	void updateDept() {
		Departments dept = inputAll();
		deptService.update(dept);
	}

	// 부서삭제
	void deleteDept() {
		int deptNo = inputDeptNo();
		deptService.delete(deptNo);
	}

	// 단건조회
	void selectOne() {
		int deptNo = inputDeptNo();
		Departments dept = deptService.selectOne(deptNo);
		if (dept == null) {
			System.out.println(deptNo + "부서는 없는 부서입니다.");
		} else {
			System.out.printf("검색결과는 부서번호:%d  부서명:%s  메니저:%d\n", dept.getDepartment_id(), dept.getDepartment_name(),
					dept.getManager_id());
		}
	}

	// 전체조회
	void selectAll() {
		List<Departments> list = deptService.selectAll();
		for (Departments dept : list) {
			System.out.printf("%d:  %s  %d\n", dept.getDepartment_id(), dept.getDepartment_name(),
					dept.getManager_id());
		}
	}

	// 입력값 숫자인지 체크
	public int readInt(String msg) {
		int num = 0;
		boolean loop = true;

		while (loop) {
			try {
				System.out.println(msg);
				num = scanner.nextInt();

				loop = false;
			} catch (InputMismatchException e) {
				System.out.println("Invalid value!");
				scanner.next();
			}
		}
		return num;
	}

	// 전체 항목 모두 입력
	Departments inputAll() {
		Departments dept = new Departments();
		dept.setDepartment_id(readInt("부서번호>"));

		System.out.print("부서명>");
		dept.setDepartment_name(scanner.next());

		dept.setManager_id(readInt("메니저>"));

		dept.setLocation_id(readInt("지역>"));
		System.out.println(dept);
		return dept;
	}

	// 부서번호만 입력
	int inputDeptNo() {
		int deptNo = 0;
		System.out.println("부서번호>");
		deptNo = scanner.nextInt();
		return deptNo;
	}
}
