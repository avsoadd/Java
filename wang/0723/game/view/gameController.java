package game.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import game.MainFrame;

@Controller
//@RequestMapping("/login")
public class gameController {

	@Autowired
	private gameService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String gameLogin() {
		return "login";
	}

	@RequestMapping(value = "/gameView", method = RequestMethod.POST)
	public String showName(String inputName, Model model) {
		service.insertName(inputName);
		model.addAttribute("inputName", inputName);
		new MainFrame();
		return "/gameView";
	}

	@RequestMapping(value = "/reward", method = RequestMethod.POST)
	public String getTicket(String inputName, Model model) {
		model.addAttribute("inputName", inputName);
		model.addAttribute("ticket", service.getTicket(inputName));
		return "reward";

	}

}
