package com.callor.bus;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.bus.dto.UserDto;
import com.callor.bus.dto.UsuallyDto;
import com.callor.bus.service.BusService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final BusService busService;

	public HomeController(BusService busService) {
		this.busService = busService;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(HttpSession httpSession, Model model) {
		UserDto userDto = (UserDto) httpSession.getAttribute("USER");
		if (userDto == null) {
			model.addAttribute("LOGINOUT", "LOGIN");
		} else {
			userDto = busService.findById(userDto.getBu_id());
			model.addAttribute("LOGINOUT", "LOGOUT");
			model.addAttribute("LOGINUSER", userDto);
		}
		return "home";

	}

	@RequestMapping(value = "/userprint", method = RequestMethod.GET)
	public String userPrint(Model model) {

		List<UserDto> userList = busService.selectAll();

		model.addAttribute("USERS", userList);
		return "userPrint";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String join(@ModelAttribute("NEWUSER") UserDto userDto, Model model) {
		UserDto dto = busService.findById(userDto.getBu_id());

		if (dto == null) {
			busService.insert(userDto);
			return "home";
		} else {
			model.addAttribute("SAMEID", "이미 존재하는 ID 입니다");
			return "join";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserDto userDto, HttpSession httpSession, Model model) {
		String msg = busService.userLogin(userDto);
		if (msg.equals("OK")) {
			httpSession.setAttribute("USER", userDto);
			model.addAttribute("LOGINOUT", "LOGOUT");
			return "redirect:/";
		} else {
			model.addAttribute("FAIL", msg);
			return "login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession, Model model) {

		// Session에 저장된 데이터를 clear
		httpSession.setAttribute("USER", null);

		// Session 자체를 모두 소멸
		httpSession.removeAttribute("USER");

		model.addAttribute("LOGINOUT", "LOGIN");
		return "redirect:/";
	}

	@RequestMapping(value = "/searcharea", method = RequestMethod.GET)
	public String searchArea() {

		return "searcharea";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(HttpSession httpSession, Model model) {

		UserDto userDto = (UserDto) httpSession.getAttribute("USER");
		if (userDto != null) {
			UserDto selectDto = busService.findById(userDto.getBu_id());
			model.addAttribute("MYUSER", selectDto);
			return "mypage";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/updateuser", method = RequestMethod.GET)
	public String update(HttpSession httpSession, Model model) {

		UserDto userDto = (UserDto) httpSession.getAttribute("USER");
		userDto = busService.findById(userDto.getBu_id());
		model.addAttribute("MYUSER", userDto);
		return "updateuser";
	}

	@RequestMapping(value = "/updateuser", method = RequestMethod.POST)
	public String update(UserDto userDto) {

		busService.update(userDto);
		return "redirect:/mypage";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(name = "id") String id, HttpSession httpSession) {
		log.debug("id정보 : {}", id);
		busService.delete(id);

		httpSession.setAttribute("USER", null);
		httpSession.removeAttribute("USER");

		return "redirect:/";
	}

	@RequestMapping(value = "/usually", method = RequestMethod.GET)
	public String usually(HttpSession httpSession, Model model) {
		UserDto userDto = (UserDto) httpSession.getAttribute("USER");
		if (userDto != null) {
			List<UsuallyDto> usList = busService.usuallyList(userDto.getBu_id());
			model.addAttribute("USLIST", usList);
			return "usually";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/nosun", method = RequestMethod.GET)
	public String gonusun(String scode, String ecode, Model model) {
		
		UsuallyDto usDto = new UsuallyDto();
		usDto.setUs_stcode(scode);
		usDto.setUs_etcode(ecode);
		model.addAttribute("USNOSUN", usDto);
		
		return "nosun";
	}
	
	@ModelAttribute("NEWUSER")
	public UserDto newUser() {
		return new UserDto();
	}
}
