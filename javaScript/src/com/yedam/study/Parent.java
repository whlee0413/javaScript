package com.yedam.study;

//
//class Child extends Parent {
//	int age;
//	int getAge() {
//		return age;
//	}
//	@Override
//	String getName() {
//		return super.getName() + ", age: " + this.age;
//	}
//	
//}
interface EmpService {
	void getEmployee(int empId);
}

public class Parent {
	String name;

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;

	}
}
