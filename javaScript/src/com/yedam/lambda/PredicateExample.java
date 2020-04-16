package com.yedam.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
	static List<Student> list = Arrays.asList(new Student("홍길동", "남자", 90, 80), new Student("김순희", "여자", 90, 85),
			new Student("김자바", "남자", 70, 55), new Student("박한나", "여자", 92, 85));

	static double avg(Predicate<Student> pred) {
		int sum = 0, cnt = 0;
		for (Student student : list) {
			if (pred.test(student)) {// return 타입: boolean 매개값으로 Student instance가 와야함
				sum += student.getEnglishScore();
				cnt++;
			} else {

			}
		}
		return (double) sum / cnt;
	}

	public static void main(String[] args) {
	      double result = avg(new Predicate<Student>() {

	         @Override
	         public boolean test(Student t) {
	            return t.getSex().equals("여자"); // 밑=
//	                  if(t.getSex().equals("남자"))
//	            return true;
//	         else
//	            return false;
	         }
	      });
	      System.out.println("여자 평균 결과 : " + result);

	      // 남자로 람다식
	      result = avg(t -> t.getSex().equals("남자"));
	      System.out.println("남자 평균 결과 : " + result);
	   }
	}