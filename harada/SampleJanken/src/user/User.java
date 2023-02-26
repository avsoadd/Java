package user;

import define.HandType;
import define.ResultType;

// ユーザ
public class User {
	// 名称
	protected String mName;
	// 手
	protected HandType mHandType;
	// 勝フラグ
	protected ResultType mResultType;

	public User(String name) {
		mName = name;
		mHandType = HandType.Invalid;
		mResultType = ResultType.Invalid;
	}

	public String getName() {
		return mName;
	}

	public void setHandType(HandType handType) {
		mHandType = handType;
	}

	public HandType getHandType() {
		return mHandType;
	}

	public void setResultType(ResultType resultType) {
		mResultType = resultType;
	}

	public ResultType getResultType() {
		return mResultType;
	}
}
