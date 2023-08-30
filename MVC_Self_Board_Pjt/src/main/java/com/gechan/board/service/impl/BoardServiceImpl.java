package com.gechan.board.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gechan.board.dao.BoardDao;
import com.gechan.board.models.BoardDto;
import com.gechan.board.models.PageDto;
import com.gechan.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	protected final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<BoardDto> selectAll() {
		// TODO Auto-generated method stub
		return boardDao.selectAll();
	}

	@Override
	public int insert(BoardDto boardDto) {
		// TODO Auto-generated method stub
		return boardDao.insert(boardDto);
	}

	@Override
	public BoardDto findById(long id) {
		// TODO Auto-generated method stub
		return boardDao.findById(id);
	}

	@Override
	public int update(BoardDto boardDto) {

		return boardDao.update(boardDto);
	}

	@Override
	public BoardDto detail(long id) {
		BoardDto boardDto = boardDao.findById(id);
		long count = boardDto.getB_viewcount();
		boardDto.setB_viewcount(++count);
		boardDao.update(boardDto);

		return boardDto;
	}

	@Override
	public List<BoardDto> selectPage(String page) {
		try {
			int intPageNum = Integer.valueOf(page);
			// intPageNum = (intPageNum -1) * 10;
			intPageNum = --intPageNum * 10;
			int intLimit = 10;
			return boardDao.selectPage(intLimit, intPageNum);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public void selectPage(String page, Model model) {
//		List<BoardDto> boards = boardDao.selectAll();
//		int totalCount = boards.size();
//		int intPageNum = Integer.valueOf(page);
//
//		PageDto pageDto = PageDto.builder().pageNum(intPageNum).totalCount(totalCount).build();
//
//		List<BoardDto> pageBoard = new ArrayList<>();
//		for (int index = pageDto.getOffSetNum(); index < pageDto.getLimitCount() + pageDto.getOffSetNum(); index++) {
//			pageBoard.add(boards.get(index));
//		}
//		model.addAttribute("BOARDS", pageBoard);
//		model.addAttribute("PAGINATION", pageDto);
		
		int totalCount = boardDao.selectCount();
		int intPageNum = Integer.valueOf(page);
		// int offSetCount = (intPageNum - 1);

		// List<BookDto> books = bookDao.selectAll();
		PageDto pageDto = PageDto.builder().pageNum(intPageNum).totalCount(totalCount).build();

		List<BoardDto> boards = boardDao.selectPage(pageDto.getLimitCount(), pageDto.getOffSetNum());

		model.addAttribute("BOARDS", boards);
		model.addAttribute("PAGINATION", pageDto);

	}

	@Override
	public List<BoardDto> findByUser(String u_id) {
		// TODO Auto-generated method stub
		return boardDao.findByUser(u_id);
	}

}
