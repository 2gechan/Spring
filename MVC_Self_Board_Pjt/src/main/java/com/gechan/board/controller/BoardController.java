package com.gechan.board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gechan.board.models.BoardDto;
import com.gechan.board.models.UserDto;
import com.gechan.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/board")
public class BoardController {

	protected final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String board(@RequestParam(name = "page", required = false, defaultValue = "1") String page, Model model) {

		boardService.selectPage(page, model);

		// List<BoardDto> boardList = boardService.selectAll();
		// model.addAttribute("BOARD_LIST", boardList);
		return "board/boardhome";
	}

	@RequestMapping(value = "/board_write", method = RequestMethod.GET)
	public String board_write(@ModelAttribute("BOARD") BoardDto boardDto, HttpSession httpSession) {

		UserDto userDto = (UserDto) httpSession.getAttribute("LOGINUSER");
		log.debug("생성된객체 : {}", userDto);
		if (userDto == null) {
			return "redirect:/user/login";
		} else {
			boardDto.setB_nickname(userDto.getU_name());
			boardDto.setB_uid(userDto.getU_id());
			return "board/board_write";
		}
	}

	@RequestMapping(value = "/board_write", method = RequestMethod.POST)
	public String board_write(@ModelAttribute("BOARD") BoardDto boardDto, Model model) {
		log.debug(boardDto.getB_content());
		int result = boardService.insert(boardDto);
		return "redirect:/board/";
	}

	@RequestMapping(value = "/board_detail", method = RequestMethod.GET)
	public String board_detail(@RequestParam(name = "num", required = false) long id, Model model) {

		BoardDto boardDto = boardService.detail(id);
		model.addAttribute("DETAIL", boardDto);

		return "board/board_detail";
	}

	@RequestMapping(value = "/board_update", method = RequestMethod.GET)
	public String board_update(@RequestParam(name = "num") long id, Model model,
			@ModelAttribute("BOARD") BoardDto boardDto, HttpSession httpSession) {

		UserDto userDto = (UserDto) httpSession.getAttribute("LOGINUSER");
		if (userDto == null) {
			return "redirect:/user/login";
		} else {
			boardDto = boardService.findById(id);
			log.debug("객체 테스트 {}", boardDto);
			model.addAttribute("UPDATE", boardDto);
			return "board/board_update";
		}

	}

	@RequestMapping(value = "/board_update", method = RequestMethod.POST)
	public String board_update(@ModelAttribute("BOARD") BoardDto boardDto, Model model) {

		log.debug("업데이트 객체 {}", boardDto);
		int result = boardService.update(boardDto);
		long seq = boardDto.getB_seq();

		return "redirect:/board/board_detail?num=" + seq;
	}

	@ModelAttribute("BOARD")
	public BoardDto newBoard() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		return BoardDto.builder().b_date(strDate).build();
	}

}
