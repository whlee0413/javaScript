package com.yedam.board;

import java.util.List;

public class BoardMain {

	public static void main(String[] args) {

		BoardDAO e = new BoardDAO();
//		List<Board> elist = e.getBoardList();
//		for (Board brd : elist) {
//			System.out.println(brd);
//		}
//		
//		Board board = new Board();
//		board.setWriter("user1");
//		board.setContent("java test");
//
//		e.insertBoard(board);
		
		Board brd = e.getBoardInfo(1);
		System.out.println(brd);
		
		
	}

}
