package com.yedam.departments;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.yedam.departments.DepartmentsDAO;
import com.yedam.departments.Departments;

import net.sf.json.JSONArray;

@WebServlet("/GetDeptsListServlet")
public class GetDeptsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetDeptsListServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		DepartmentsDAO dao = new DepartmentsDAO();
		
	      for (Departments d : dao.getDepartmentsList()) {
	         obj.put("deptId", b.getdeptId());
	         obj.put("deptName", b.getdeptName());
	         obj.put("mngrId", b.getmngrId());
	         obj.put("lctnId", b.getlctnId());
	         ary.add(obj);
	      }
	      
	      PrintWriter out = response.getWriter();
	      out.print(ary.toString());
	   
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}