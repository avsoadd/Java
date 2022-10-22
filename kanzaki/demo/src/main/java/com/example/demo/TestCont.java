package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class TestCont {

	@GetMapping("/")
	public String disp1(Model model) {
		
		if (!model.containsAttribute("User")) {
			model.addAttribute("User", new User());
		}
		return "test";
	}

	@PostMapping("/inputCheck")
	public String disp2(
			@ModelAttribute("User") @Validated User User, 
			BindingResult br, 
			RedirectAttributes redirectAttributes) {
		if (br.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.User", br);
			redirectAttributes.addFlashAttribute("User", User);
			return "test";
		}
		return "confirm";
	}
}
