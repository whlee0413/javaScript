package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamExample2 {

	public static void main(String[] args) throws IOException {
		String path = "src/com/yedam/io/test.jpg";
		FileInputStream fis = new FileInputStream(path);
		int readByte;
		long start = System.nanoTime();
		while ((readByte = fis.read()) != -1) { // read는 더 이상 읽을 값이 없을때 -1을 리턴해줌.

		}
		fis.close();
		long end = System.nanoTime();
		System.out.println((end - start) + " ns");
		System.out.println("====end====");

		FileInputStream fis2 = new FileInputStream(path);
		byte[] buf = new byte[100];
		start = System.nanoTime();
		while ((readByte = fis2.read(buf)) != -1) {

		}
		fis2.close();
		end = System.nanoTime();
		System.out.println((end - start) + " ns");
	}
}
