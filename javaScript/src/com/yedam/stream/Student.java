package com.yedam.stream;

public class Student {
	
	   public enum Gender {MALE, FEMALE}
	   public enum City {Seoul, Busan}

	   String name;
	   int score;
	   Gender gender; // MALE, FEMALE이 있다.
	   City city;      // Seoul, Busan이 있다.

	   public Student() {}
	   public Student(String name, int score) {
	      super();
	      this.name = name;
	      this.score = score;
	   }
	   public Student(String name, int score, Gender gender) {
	      super();
	      this.name = name;
	      this.score = score;
	      this.gender = gender;
	   }

	   public String getName() {return name;}
	   public int getscore() {return score;}
}