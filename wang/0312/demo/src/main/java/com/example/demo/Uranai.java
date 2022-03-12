package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//DBにid=0~9の答え10個を用意
// a.受け取った質問のlenth   b.1~10のランダムに生成した整数
// aかけるbの結果の下1桁をidにする
// そのidで答えを引っ張てきて、表示


@RestController
public class Uranai {
	private String question;
	private String answer;

	@RequestMapping(value="/input", method=RequestMethod.GET)
    public ModelAndView input(ModelAndView mav) {
        mav.setViewName("input");
        mav.addObject("inputQuestion", "question");    // 表示メッセージ
        return mav;
    }

	@RequestMapping(value="/output", method=RequestMethod.POST)
    public Model output(@RequestParam("inputQuestion") String inputQuestion, Model model) {
        model.addAttribute("inputQuestion", inputQuestion);

        question = inputQuestion;
        return model;
    }




	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
