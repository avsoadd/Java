package com.example.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/colorInput")
public class ColorController {
	@Autowired
	private ColorService service;

	@RequestMapping(value = "/colorInput", method = RequestMethod.GET)
	public String input() {
		return "colorInput";
	}

	@RequestMapping(value = "/colorOutput", method = RequestMethod.POST)
	public String output(int inputBirth, String weather, Model model) {
		String colorCode = service.getColor(inputBirth, weather);
		model.addAttribute("colorCode", colorCode);

		return "ColorOutput";
	}
	//	public String doPost(HttpServletRequest request, HttpServletResponse response)
	//		    throws IOException, ServletException{
	//
	//		    String weather = request.getParameter("weather");
	//		    String colorCode=service.getResult(inputBirth,);
	//
	//		    return "colorOutput";
	//		  }
}
