package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.LoginForm;

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
			return "logout";
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
}