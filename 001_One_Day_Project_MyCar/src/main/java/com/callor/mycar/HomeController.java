package com.callor.mycar;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.mycar.models.MyCarDto;
import com.callor.mycar.models.service.MyCarService;

@Controller
public class HomeController {

	private final MyCarService mcService;

	public HomeController(MyCarService mcService) {
		this.mcService = mcService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<MyCarDto> mcList = mcService.selectAll();

		model.addAttribute("LIST", mcList);

		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String insert(MyCarDto dto) {

		dto.setMc_sdate(mcService.date());
		dto.setMc_stime(mcService.time());

		mcService.insert(dto);

		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model model) {

		MyCarDto dto = mcService.findById(id);
		model.addAttribute("DATA", dto);
		return "update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute MyCarDto dto) {

		if (dto.getMc_edistance() != null) {
			dto.setMc_edate(mcService.date());
			dto.setMc_etime(mcService.time());
		}

		mcService.update(dto);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		System.out.println(id + "삭제");

		mcService.delete(id);
		return "redirect:/";
	}

}
