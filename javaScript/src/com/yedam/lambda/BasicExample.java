package com.yedam.lambda;

import java.awt.Toolkit;

//class RunnableCls implements Runnable {
//	@Override
//	public void run() {
//		Toolkit tkit = Toolkit.getDefaultToolkit();
//		for (int i = 0; i < 10; i++)
//			tkit.beep();
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//	} 
//	
//}

public class BasicExample {
	public static void main(String[] args) {
		Runnable rcs = new Runnable() {
			@Override
			public void run() {
				Toolkit tkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 10; i++)
					tkit.beep();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

//		Runnable rcs = new Runnable(); // 신규작업 인스턴스
		Thread thread = new Thread(() -> {
			Toolkit tkit = Toolkit.getDefaultToolkit();
			for (int i = 0; i < 10; i++) {
				System.out.println("삐삐");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}); // 쓰레드생성
		thread.start(); // 신규쓰레드작업 시작.

		for (int i = 0; i < 10; i++) {
			System.out.println("print it.=> " + i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
