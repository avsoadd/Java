package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/")
	public String hello1(Model model) {
		model.addAttribute("message", "Hello, Default Spring Boot!");
		return "hello";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "Hello, Spring Boot!");
		return "hello";
	}

}