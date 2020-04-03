package com.yedam.lambda;

@FunctionalInterface
interface MyInterface1 {
	void get(String str); // 메소드 안에 매개값을 선언,입력해서 하는 방법.
}

@FunctionalInterface
interface MyInterface2 {
	String get(String str, String str1);
}

interface Consumer<T> {
	void get(T t);
}

class ConsumerClass<T> implements Consumer<T> {
	@Override
	public void get(T t) {    //*111111111111
		System.out.println(t);
	}
}

//객체타입 lambda 방식
class Students { 
	String name;
	int age;
	Students(String name, int age){
		this.name = name;
		this.age = age;
	}
	void getInfo() {
		System.out.println("이름: "+ this.name + ", 나이: " + this.age);
	}
}


//class MyInterClass implements MyInterface1{
//	@Override
//	public void get() {		
//		System.out.println();
//	}
//}

public class BasicExample2 {

	public static void main(String[] args) {
		MyInterface1 mi = (s) -> {
			System.out.println("Hello" + ", " + s);
		};
		mi.get("Lee"); // 매개값 입력

		
		MyInterface2 mi2 = new MyInterface2() {
			@Override
			public String get(String str, String str1) {
				return str.concat(str1); // str + str1
			}
		};
		
		String result = mi2.get("Hello ", "World");
		System.out.println(result);
		
		
		Consumer<String> cc = new Consumer<String>() {
			public void get(String t) {
			System.out.println("Hello Consumer " + t);
			}
		};
		cc.get("wonho");  //*1111111111 메소드 확인

//		Consumer<String> cc = (k) -> {
//			System.out.println("Hello " + k);
//		};
//		cc.get("dude");
		
		Consumer<Students> conStudents = (t) -> { //객체타입
			t.getInfo();
		};
		Students s1 = new Students("Lee", 30);
				conStudents.get(s1);
	}
}
