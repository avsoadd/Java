package com.mailservice;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class webUIController {
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(HttpServletResponse response) throws Exception {
		return "home";
		}
	
	@RequestMapping(path = "/form", method = RequestMethod.GET)
	public String form(HttpServletResponse response) throws Exception {
		return "form";
		}
	
	@RequestMapping(path = "/mypage", method = RequestMethod.GET)
	public String mypage(HttpServletResponse response) throws Exception {
		return "mypage";
		}
}
