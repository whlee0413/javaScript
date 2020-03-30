package com.yedam.board;

import java.util.List;

public class BoardMain {

	public static void main(String[] args) {

		BoardDAO b = new BoardDAO();
		List<Board> blist = b.getBoardList();
		for (Board brd : blist) {
			System.out.println(brd);
		}
		
		Board board = new Board();
		board.setWriter("user1");
		board.setContent("java test");

		b.insertBoard(board);
		
		Board brd = b.getBoardInfo(1);
		System.out.println(brd);
		
		
	}

}