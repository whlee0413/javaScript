package com.yedam.employee;

public class Employee {
	 int salary;
	 String firstName;
	public Employee(int salary, String firstName) {
		super();
		this.salary = salary;
		this.firstName = firstName;
	}
	public int getSalary() {
		return salary;
	}
	public String getFirstName() {
		return firstName;
	}
	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", firstName=" + firstName + "]";
	}
	
}
