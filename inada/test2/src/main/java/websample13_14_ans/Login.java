package websample13_14_ans;

/**
 * Java入門 ログイン処理クラス.<br/>
 * 今回は親クラスとして使用.
 */
public class Login {

	/**
	 * 指定されたIDとパスワードに紐づくユーザ情報を返却します.
	 * @param id	ID
	 * @param pass	パスワード
	 * @return ユーザ情報
	 */
	public LoginUserBean getUserData(String id, String pass) {
		
		LoginUserBean bean = new LoginUserBean();
		
		// 引数のIDとパスワードを判定
		if("web01".equals(id) && "password".equals(pass)) {
			
			// IDがweb01の場合
			// BeanにIDを設定
			bean.setId(id);
			// Beanに名前を設定
			bean.setName("すく太郎");
			// Beanに年齢を設定
			bean.setAge(17);
			
		} else if ("web02".equals(id) && "password".equals(pass)) {
			
			// IDがweb02の場合
			// BeanにIDを設定
			bean.setId(id);
			// Beanに名前を設定
			bean.setName("すく次郎");
			// Beanに年齢を設定
			bean.setAge(10);
			
		} else {
			
			// IDが合致しない場合はnullを代入
			bean = null;
		}
		
		return bean;
	}
}