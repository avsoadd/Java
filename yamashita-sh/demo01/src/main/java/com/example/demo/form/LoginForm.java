package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
/**
 * ログイン用Form
 */
public class LoginForm {
	@NotNull
	@NotBlank
	private String loginId;
	@NotNull
	@NotBlank
	private String loginPassword;
	/**
	 * @return loginId
	 */
	public String getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId セットする loginId
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * @return loginPassword
	 */
	public String getLoginPassword() {
		return loginPassword;
	}
	/**
	 * @param loginPassword セットする loginPassword
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
}