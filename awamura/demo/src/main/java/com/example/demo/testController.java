package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class testController {
	
	@Autowired
	JdbcTemplate jdbc;

	@GetMapping(value="/")
//	public String index() {
//		List<Map<String, Object>> list;
//		list = jdbc.queryForList("select * from test");
//		return "index";
//	}
	@PostMapping(value="/")
	public String login(Model model, String name) {
		model.addAttribute("name", name);
		return "login";
	}
	
}
