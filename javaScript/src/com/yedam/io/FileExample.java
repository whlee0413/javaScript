package com.yedam.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

public class FileExample {
	public static void main(String[] args) throws URISyntaxException, IOException {
		File dir = new File("C:/Temp/Dir");
		File file1 = new File("C:/Temp/file1.txt");
		File file2 = new File("C:/Temp/file2.txt");
		File file3 = new File(new URI("file:///C:/Temp/file3.txt"));
		
		if(dir.exists()==false)
			dir.mkdirs();
		
		if(file1.exists()==false)
			file1.createNewFile();
		
		if(file2.exists()==false)
			file2.createNewFile();
		
		if(file3.exists()==false)
			file3.createNewFile();
				
		File temp = new File("C:/Temp");
		File[] files = temp.listFiles();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd     a     HH:mm");
		for(File file : files)	{
			System.out.print(sdf.format(file.lastModified()));
			if(file.isDirectory())
				System.out.print("\t<Dir>\t\t"+ file.length() + "\t" + file.getName());
			else
				System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
			System.out.println();
		}
	}
}
