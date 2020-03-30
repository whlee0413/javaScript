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

import com.yedam.board.BoardDAO;
import com.yedam.board.Board;

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
		BoardDAO dao = new BoardDAO();
		
	      for (Board b : dao.getBoardList()) {
	         obj.put("boardNo", b.getBoardNo());
	         obj.put("content", b.getContent());
	         obj.put("writer", b.getWriter());
	         obj.put("date", b.getDate());
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