package com.yedam.lambda;

// 기존에는 이렇게 써서 new RunnableImpl(); 로 생성자 사용
//class RunnableImpl implements Runnable {          Runnable이라는 interface를 구현하는 RunnableImpl이라는 class
//
//	@Override
//	public void run() { Runnable구현객체의 메소드
//		System.out.println("runnable call.");
//	} 
//	
//}



public class BasicExpressExample {
	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() {  //익명객체
			@Override
			public void run() {
				System.out.println("runnable call.");
			}
		};
		runnable.run();
		
		
//		===========위와 아래는 같은 방식==================
		Runnable runnable1 = () -> {
				System.out.println("runnable lambda call.");
			};
		runnable1.run();
	}
}
