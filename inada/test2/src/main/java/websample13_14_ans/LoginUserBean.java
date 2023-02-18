package websample13_14_ans;

import java.io.Serializable;

/**
 * Java入門 ログインユーザ情報クラス.
 */
public class LoginUserBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;			// ID
	private String name;		// 名前
	private int age;			// 年齢
	
	/**
	 * コンストラクタ.<br>
	 * メンバ変数の値を初期化します.
	 */
	public LoginUserBean() {
		this.id   = "";
		this.name = "";
		this.age  = 0;
	}
	
	/**
	 * IDを返却します.
	 * @return ID
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * IDを設定します.
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 名前を返却します.
	 * @return 名前
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 名前を設定します.
	 * @param name 名前
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 年齢を返却します.
	 * @return 年齢
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * 年齢を設定します.
	 * @param age 年齢
	 */
	public void setAge(int age) {
		this.age = age;
	}
}