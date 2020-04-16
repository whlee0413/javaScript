package com.yedam.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class StreamExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동", "김유신", "하준원", "홍성우");
//	==> name.txt

		
		File fileReader = new File(list);
		FileReader fr = new FileReader(fileReader);
		int readChar;
		char[] cbuf = new char[100];
		while ((readChar = fr.read(cbuf)) != -1) {
			String text = new String(cbuf, 0, readChar);
			System.out.println(text);
		}
		fr.close();
	}
}
