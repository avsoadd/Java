package define;

// 結果
public enum ResultType {
	Invalid(-1),	// 無効値
	Defeat(0),		// 負け
	Win(1),			// 勝ち
	Draw(2);		// あいこ

	private int mResultType;

	private ResultType(int resultType) {
		mResultType = resultType;
	}

	public ResultType cast(int resultType) {
		ResultType eResultType = ResultType.Invalid;

		switch(resultType) {
		case 0:
			eResultType = Defeat;
			break;
		case 1:
			eResultType = Win;
			break;
		case 2:
			eResultType = Draw;
			break;
		default:
			// 無効値のまま
			break;
		}

		return eResultType;
	}

	public int getResultType() {
		return mResultType;
	}
}
