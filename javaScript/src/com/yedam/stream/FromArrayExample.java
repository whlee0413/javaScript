package com.yedam.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArrayExample {

	public static void main(String[] args) {
		String[] strArry = { "Hong", "Hwang", "Choi"};
		Stream<String> strStream = Arrays.stream(strArry);
		int[] intArry = { 3,4,2,5,1,6};
		IntStream intStream = Arrays.stream(intArry);
		
		strStream.forEach(s -> System.out.println(s));
		intStream.forEach(i -> System.out.println(i));
		System.out.println("=================================");
		IntStream rangeStream = IntStream.rangeClosed(1,10);
		rangeStream.forEach(r-> System.out.println(r));
	}
}
