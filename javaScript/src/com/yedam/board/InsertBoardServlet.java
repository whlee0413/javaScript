package com.yedam.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertBoardServlet")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertBoardServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		 String content = request.getParameter("content");
	      String writer = request.getParameter("writer");
	      System.out.println("content: " + content + "writer: "+ writer);
	      
	      Board brd = new Board();
	      brd.setContent(content);
	      brd.setWriter(writer);
	      BoardDAO dao = new BoardDAO();
	      dao.insertBoard(brd);
	   }
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}