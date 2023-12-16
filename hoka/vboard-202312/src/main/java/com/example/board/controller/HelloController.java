package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.board.Service.TestService;

import model.Users;

@Controller
public class HelloController {

	
	@Autowired
	private TestService testService;

	//public HelloController(TestService testService) {
	//	this.testService = testService;
	//}

    
	@GetMapping("/")
	public String hello1(Model model) {
		List<Users> users = testService.getUserById();
		model.addAttribute("message", "Hello, Default Spring Boot!" + users.toString());
		return "hello";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "Hello, Spring Boot!");
		return "hello";
	}

}