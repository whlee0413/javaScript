package com.yedam.stream;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class AgreegateExample {
	public static void main(String[] args) {
		IntStream intStream = Arrays.stream(new int[] {1,2,3,4,5});
		long cnt = intStream.filter(n->n%2==0).count();
		intStream = IntStream.rangeClosed(1, 10);
		OptionalDouble d = intStream.filter(n->n%2==1).average();
		System.out.println("결과: "+d);
	}
}
