package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.form.LoginForm;
import com.example.demo.form.UserForm;

import jakarta.servlet.http.HttpSession;

/**
 * ログイン機能クラス.
 */
@Controller
public class SchooController {

	@Autowired
	HttpSession session;

	/**
	 * トップページの表示<br>
	 * ログイン済みの場合はログアウト画面を表示
	 * @return
	 */
	@GetMapping("/")
	public String index() {
		// ログイン状態のチェック
		String login = (String)session.getAttribute("login");
		if ("ok".equals(login)) {
			return "user";
			//return "input";
		} else {
			return "index";
		}
	}
	
	/**
	 * ログイン処理
	 * @param loginForm	ログインForm
	 * @param bindingResult	入力チェック結果
	 * @return	処理結果ページのパス
	 */
	@PostMapping("login")
	public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm,
						BindingResult bindingResult) {
		// 入力チェック
		if (bindingResult.hasErrors()) {
			return "login-ng";
		}

		// IDとパスワードのチェック
		if ("schoo".equals(loginForm.getLoginId()) &&
			"pass".equals(loginForm.getLoginPassword())) {
			session.setAttribute("login", "ok");
			return "login-ok";
		} else {
			return "login-ng";
		}
	}
	
	/**
	 * ログアウト処理
	 * @return
	 */
	@GetMapping("logout")
	public String logout() {
		session.invalidate();
		return "index";
	}
	
	/**
	 * 入力処理リクエスト
	 * @param 	入力メッセージ
	 * @return 結果画面のパス
	 */
	@PostMapping("input")
	public String input(@RequestParam String message1,
						@RequestParam String message2,
						@RequestParam String message3,
						Model model) {
		// endが入力されたらリストを作成しない
		if(!"end".equals(message3)) {
			model.addAttribute("result", "処理が終了しました");
			// input画面で入力されたメッセージをリストにセット
			ArrayList<String> messages = new ArrayList<>();
			messages.add(message1);
			messages.add(message2);
			messages.add(message3);
			// インラインで表示するメッセージをセット
			model.addAttribute("messages", messages);
		}

		return "output";
	}

	/**
	 * 
	 * @return
	 */
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	/**
	 * 入力処理リクエスト
	 * @param 	userForm ユーザ情報
	 * @param	bindingResult ユーザ情報の入力チェック結果
	 * @param 	model 画面に受け渡しをする情報
	 * @return 入力画面のパス
	 */
	@PostMapping("input_userform")
	public String input_userform(@Validated UserForm userForm,
						BindingResult bindingResult,
						Model model) {
		// 入力チェック結果のメッセージ
		String message;

		if(bindingResult.hasErrors()) {
			// 入力に誤りがある場合
			message = "入力内容に誤りがあります。";
		} else {
			// 入力が正しい場合
			message = "正しく入力できました。";
		}

		// 入力チェック結果をModelにセット
		model.addAttribute("message", message);

		return "user";
	}

}