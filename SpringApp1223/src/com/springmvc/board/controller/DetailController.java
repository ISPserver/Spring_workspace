package com.springmvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.model2.board.model.BoardDAO;
import com.model2.domain.Board;

public class DetailController implements Controller {
	private BoardDAO boardDAO;
	
	//DI�� ���� setter
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String board_id = request.getParameter("board_id");
		
		//3�ܰ�: �˸´� ��ü�� �� ��Ű��
		Board board = (Board)boardDAO.select(Integer.parseInt(board_id));
		
		//4�ܰ�: �����Ұ� ����
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board", board);
		
		return mav;
	}

}
