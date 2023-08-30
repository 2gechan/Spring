package com.gechan.board.service;

import java.util.List;

import org.springframework.ui.Model;

import com.gechan.board.models.BoardDto;

public interface BoardService {

	public List<BoardDto> selectAll();

	public int insert(BoardDto boardDto);

	public BoardDto findById(long id);

	public int update(BoardDto boardDto);

	public BoardDto detail(long id);
	
	public List<BoardDto> selectPage(String page);
	
	public void selectPage(String page, Model model);
	// public void selectPage(String page, Model model, String search);

	public List<BoardDto> findByUser(String u_id);

}
