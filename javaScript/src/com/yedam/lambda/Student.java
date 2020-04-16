package com.yedam.lambda;

public class Student {
	String name;
	String sex;
	int englishScore;
	int mathScore;

	public Student() {
	}

	public Student(String name, int engishScore, int mathScore) {
		this.name = name;
		this.englishScore = engishScore;
		this.mathScore = mathScore;
	}

	public Student(String name, String sex, int engishScore, int mathScore) {
		this.name = name;
		this.sex = sex;
		this.englishScore = engishScore;
		this.mathScore = mathScore;
	}

	public String getName() {
		return name;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public String getSex() {
		return sex;
	}
}
