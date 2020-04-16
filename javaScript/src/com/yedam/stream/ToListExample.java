package com.yedam.stream;

import java.util.Arrays;
import java.util.List;

public class ToListExample {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("Hong", 10, Student.Gender.MALE),
				new Student("Hwang", 9, Student.Gender.FEMALE),
				new Student("Choi", 8, Student.Gender.MALE),
				new Student("Hwang", 7, Student.Gender.FEMALE),
		);
		list.stream().filter( s->s.getGender() == Student.Gender.MALE)
			.collect(Collectors.toList()); //Hong,Choi => List
		maleStudent.stream().forEach(s->s.getName());
	}
}
