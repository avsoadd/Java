package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestCont {
	@GetMapping (path = "/")
	public String test (@ModelAttribute User user) {
		return "test";
	}
	@PostMapping (path = "/confirm")
	public String confirm (@ModelAttribute User user) {
		return "confirm";
	}
}
