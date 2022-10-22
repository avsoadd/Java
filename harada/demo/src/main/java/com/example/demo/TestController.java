package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@PostMapping("")
	public void  receive(@RequestBody String json) {
		System.out.println("receive");
		System.out.println(json);
		//return "/";
	}
}
