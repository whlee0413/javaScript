package com.yedam.dev;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetEmpListServlet")
public class GetEmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetEmpListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//		response.getWriter().append("Served at: ").append(request.getContextPath()).append("LWH");
		EmpDAO dao = new EmpDAO();
		List<Employee> empList = dao.getEmpList();

//		{"id":1,"first_name":"Miles","last_name":"Le Barr","email":"mlebarr0@blinklist.com","gender":"Male","ip_address":"65.77.222.115"},
//		{"id":2,"first_name":"Timofei","last_name":"Kitchiner","email":"tkitchiner1@domainmarket.com","gender":"Male","ip_address":"48.145.49.243"},
//		{"id":3,"first_name":"Brooke","last_name":"Isakov","email":"bisakov2@mediafire.com","gender":"Male","ip_address":"4.82.186.114"},
		
		String empJson = "[";
	      int rCnt = 0;
	      int totalCnt = empList.size();
	      for (Employee e : empList) {
	         empJson += "{\"empId\":" + e.getEmployeeId() 
	         + ",\"firstName\":\"" + e.getFirstName() 
	         + "\",\"lastName\":\"" + e.getLastName()
	         + "\",\"email\":\"" + e.getEmail()
	         + "\",\"departmentId\":\"" + e.getDepartmentId()
	         + "\",\"salary\":\"" + e.getSalary()
	         + "\"}";
	         
	         
	         if(++rCnt != totalCnt)
	            empJson += ","; //같아지는 시점에 ,를 생성
	      }
	      empJson += "]";
	      PrintWriter out = response.getWriter();
	      out.print(empJson.toString());
	   }

	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	      doGet(request, response);
	   }

}