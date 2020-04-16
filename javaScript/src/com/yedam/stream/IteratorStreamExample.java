package com.yedam.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorStreamExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동","신용권","김자바");
		//Iterator사용
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("=========================");
		//Stream 사용
		Stream<String> stream = list.stream();
//		stream.forEach(s -> System.out.println(s.toString()));
		stream.forEach(System.out::println); // 위와 같음
	}

}
