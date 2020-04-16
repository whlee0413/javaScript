package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamExample {

	public static void main(String[] args) throws IOException {
		String path = "src/com/yedam/io/Input.txt";
		FileInputStream fis = new FileInputStream(path);
		String outPath = "src/com/yedam/io/Output.txt";
		FileOutputStream fos = new FileOutputStream(outPath);

		int readByte;
		while ((readByte = fis.read()) != -1) { // read는 더 이상 읽을 값이 없을때 -1을 리턴해줌.
//			System.out.print((char) readByte);
//		}
			fos.write(readByte);
			System.out.print((char) readByte);
		}
		fos.flush();
		fos.close();
		fis.close();
	}

}
