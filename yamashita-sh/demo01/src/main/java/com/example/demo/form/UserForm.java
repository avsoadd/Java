package com.example.demo.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * ユーザ情報のFormクラス
 */
public class UserForm {
	@NotBlank
	private String name;
	@NotBlank
	@Pattern(regexp = "[0-9]*")
	private String age;
	@NotBlank
	@Email
	private String mailAddress;

	/**
	 * コンストラクタ
	 * @param name
	 * @param age
	 * @param mailAddress
	 */
	public UserForm(String name, String age, String mailAddress) {
		this.name = name;
		this.age = age;
		this.mailAddress = mailAddress;
	}
	/**
	 * コンストラクタ
	 */
	public UserForm() {
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age セットする age
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * @return mailAddress
	 */
	public String getMailAddress() {
		return mailAddress;
	}
	/**
	 * @param mailAddress セットする mailAddress
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
}