package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
//@RequestMapping("/input")
public class controller {
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String input(@ModelAttribute("uranai") Uranai uranai){
		 return "input";
		 }

	@RequestMapping(value="/output",method=RequestMethod.GET)
    public String output(@ModelAttribute("uranai1") Uranai uranai1){
//		model.addAttribute("question",question);
    	return "output";
    }



}

