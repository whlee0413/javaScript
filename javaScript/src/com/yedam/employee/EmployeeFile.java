package com.yedam.employee;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class EmployeeFile {
	try(FileWriter fout= new FileWriter("D:/Dev/git/javaScript/javaScript/src/com/yedam/employee/employeeOutput.txt"
)) {
	    PrintWriter out = new PrintWriter(fout);
	    for( String line:texts ) {
	        out.println(line);
	    }
}