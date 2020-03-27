package com.yedam.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.yedam.dev.Dev.EmpDAO;
import com.yedam.dev.Dev.Employee;

import net.sf.json.JSONArray;

@WebServlet("/GetBoardListServlet")
public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetBoardListServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		JSONObject obj = new JSONObject();
		JSONArray ary = new JSONArray();
		EmpDAO dao = new EmpDAO();
		
	      for (Employee e : dao.getEmpList()) {
	         obj.put("empId", e.getEmployeeId());
	         obj.put("firstname", e.getFirstName());
	         obj.put("lastname", e.getLastName());
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
