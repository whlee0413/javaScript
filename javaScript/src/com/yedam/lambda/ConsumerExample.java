package com.yedam.lambda;

import java.util.function.BiConsumer;

public class ConsumerExample {

	public static void main(String[] args) {
		BiConsumer<Students, String> biCon = (std, str) ->{
			System.out.println(str + " ");
			std.getInfo(); //안녕하세요 이름:?? 나이:??
		};
		Students s1 = new Students("Hwang", 20);
		String s2 = "안녕하세요";
		biCon.accept(s1, s2);
	}
	
	static <T, U> void printAccept(BiConsumer<T, U> biCon, T std, U str) {
		biCon = (std, str) -> {
			System.out.println(str + " ");
			std.getInfo();
		};
		biCon.accept(std, str);
	}

}
