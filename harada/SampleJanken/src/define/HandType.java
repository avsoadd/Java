package define;

// 手（じゃんけんの種別）
public enum HandType {
	Invalid(-1),	// 無効値
	Gu(1),			// グー
	Tyoki(2),		// チョキ
	Par(3);			// パー

	private int mHandType;

	private HandType(int handType)
	{
		mHandType = handType;
	}

	public HandType cast(int handType) {
		HandType eHandType = HandType.Invalid;

		switch(handType) {
		case 1:
			eHandType = Gu;
			break;
		case 2:
			eHandType = Tyoki;
			break;
		case 3:
			eHandType = Par;
			break;
		default:
			// 無効値のまま
			break;
		}

		return eHandType;
	}

	public int getHandType() {
		return mHandType;
	}
}
