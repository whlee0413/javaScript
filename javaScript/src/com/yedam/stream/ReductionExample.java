package com.yedam.stream;

import java.util.Arrays;
import java.util.List;

public class ReductionExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("hong",30),
				new Student("Lee",99),
				new Student("Kim",88));
		int sum = list.stream().flatMapToInt(s->s.getScore()).sum();
		list.stream().flatMapToInt(s->s.getScore()).reduce((a,b) -> a+b)
	}
}
