package com.example.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.board.Service.TestService;
import com.example.board.Service.UserService;
import com.example.board.dto.UserListParam;

@Controller
public class HelloController {

	@Autowired
	private TestService testService;
	@Autowired
	private UserService userService;

	//public HelloController(TestService testService) {
	//	this.testService = testService;
	//}
/*
	@GetMapping("/")
	public String hello1(Model model) {
		List<Users> users = testService.getUserById();
		model.addAttribute("message", "Hello, Default Spring Boot!" + users.get(0).getUserName());
		return "hello";
	}
*/
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "Hello, Spring Boot!");
		return "hello";
	}

	/**
	 * ユーザー情報一覧画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping(value = "/")
	public String displayList(Model model) {
		UserListParam userListParam = userService.searchAll();
		model.addAttribute("userListParam", userListParam);
		return "UserNameList";
	}

	@RequestMapping(value = "/listUpdate", method = RequestMethod.POST)
	public String listUpdate(@Validated @ModelAttribute UserListParam userListParam, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				if (!errorList.contains(error.getDefaultMessage())) {
					errorList.add(error.getDefaultMessage());
				}
			}
			model.addAttribute("validationError", errorList);
			return "UserNameList";
		}
		// ユーザー情報の更新
		userService.updateAll(userListParam);
		return "redirect:/";
	}

}