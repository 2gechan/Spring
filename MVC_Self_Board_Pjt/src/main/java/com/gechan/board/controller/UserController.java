package com.gechan.board.controller;

import java.util.List;

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
import com.gechan.board.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/user")
@Controller
public class UserController {

	protected final UserService userService;
	protected final BoardService boardService;
	public UserController(UserService userService, BoardService boardService) {
		this.userService = userService;
		this.boardService = boardService;
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(@RequestParam(name = "message", required = false) String MESSAGE, Model model) {

		model.addAttribute("MESSAGE", MESSAGE);

		return "user/join";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(name = "message", required = false) String message, Model model) {

		model.addAttribute("MESSAGE", message);

		return "user/login";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("USER") UserDto userDto) {

		String MESSAGE = userService.join_check(userDto);
		if (MESSAGE.equals("IDOK")) {
			int result = userService.insert(userDto);
			return "redirect:/";
		} else {

			return "redirect:/user/join?message=" + MESSAGE;
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession httpSession, @ModelAttribute("USER") UserDto userDto) {
		log.debug("로그인 유저 : {} ", userDto);

		String MESSAGE = userService.login(userDto.getU_id(), userDto.getU_password());
		if (MESSAGE.equals("LOGINOK")) {
			userDto = userService.findById(userDto.getU_id());
			httpSession.setAttribute("LOGINUSER", userDto);
			return "redirect:/";
		} else {
			return "redirect:/user/login?message=" + MESSAGE;
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("LOGINUSER");
		return "redirect:/";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(HttpSession httpSession, Model model) {
		UserDto userDto = (UserDto) httpSession.getAttribute("LOGINUSER");
		if(userDto == null) {
			return "redirect:/user/login";
		}
		List<BoardDto> userBoardList = boardService.findByUser(userDto.getU_id());
		model.addAttribute("USER", userDto);
		model.addAttribute("USERBOARD", userBoardList);
		return "user/mypage";
	}

	@ModelAttribute("USER")
	public UserDto newUser() {
		return new UserDto();
	}

}
