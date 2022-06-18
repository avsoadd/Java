package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/input")
public class UranaiController {
	@Autowired //Springの中で特定なクラス(@がついているクラス)を自動的に使う
	private UranaiService service;

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input() {
		return "input";
	}

	@RequestMapping(value = "/output", method = RequestMethod.POST)
	public String output(String inputQuestion, Model model) {
		String answer = service.getResult(inputQuestion);
		model.addAttribute("inputQuestion", inputQuestion);
		model.addAttribute("answer", answer);

		return "output";
	}

}
