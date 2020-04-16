package com.yedam.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CellPhone {
	static String fileName = "phoneList.txt";

	static class Address {
		String name;
		String age;
		String phone;

		public Address(String name, String age, String phone) {
			super();
			this.name = name;
			this.age = age;
			this.phone = phone;
		}

	}

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String menu = "";
		System.out.println("친구 연락처 관리.");
		System.out.println("이름:");
		String name = scn.nextLine();
		System.out.println("나이:");
		String age = scn.nextLine();
		System.out.println("전화번호:");
		String phone = scn.nextLine();
		System.out.println("입력완료.");

		Address addr = new Address(name, age, phone);
		
		File fileName = new File("D:/Dev/git/javaScript/javaScript/src/com/yedam/io/CellPhoneBook.txt");

		try {
			FileWriter writer = new FileWriter(fileName, true);
			writer.write("\n" + addr.name + ", " + addr.age + ", " + addr.phone + "\n");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
