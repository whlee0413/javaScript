package com.yedam.study;

public class ParentExample {

	public static void main(String[] args) {
		Parent p = new Parent();
		p.name = "hong";
		showInfo(p);
//		Child c = new Child();
//		c.name = "Hwang";
//		c.age = 10;

//		==============익명객체=============
		showInfo(new Parent() {
			int age;
			int getAge() {
				return age;
			}

			@Override
			String getName() {
				super.setName("Hwang");
				return super.getName();
			}

		});
//		\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		EmpService empService = new EmpServiceImpl() {
		
			@Override
			public void getEmployee(int empId) {
				System.out.println("empId: " + empId);
			}
		};
		getEmp(empService);
		
//		위에랑 같은 방식 바로 아래
//		getEmp(new EmpServiceImpl() {
//		
//			@Override
//			public void getEmployee(int empId) {
//				System.out.println("empId: " + empId);
//			}
//		});
		
//		\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	}
	static void getEmp(EmpService emp) {
		emp.getEmployee(101);
	};
	
	static void showInfo(Parent p) {
		System.out.println(p.getName());
	}
}
