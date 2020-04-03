package com.yedam.lambda;

public class Student {
	private String name;
	private int englishScore;
	private int mathScore;

	public Student(String name, int engishScore, int mathScore) {
		this.name = name;
		this.englishScore = engishScore;
		this.mathScore = mathScore;
	}
	public String getName() {return name;}
	public int getEnglishScore() {return englishScore;}
	public int getMathScore() {return mathScore;}
	
	}
