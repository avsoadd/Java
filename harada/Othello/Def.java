
public class Def
{
	// 駒種別
	public enum KOMATYPE
	{
		UNKNOWN,
		WHITE,
		BLACK,
	}

	// 勝者種別
	public enum WINNERTYPE
	{
		UNKNOWN,
		DROW,
		WHITE,
		BLACK,
	}

	public enum OFFSETTYPE
	{
		LEFT,
		RIGHT,
		UP,
		DOWN,
		LEFT_UP,
		RIGHT_UP,
		LEFT_DOWN,
		RIGHT_DOWN,
	}

	// プレイヤー1
	public static final int PLAYERONE = 0;
	// プレイヤー2
	public static final int PLAYERTWO = 1;
	// プレイヤー数
	public static final int PLAYERNUM = 2;

	// 盤面数
	public static final int FIELDNUM = 8 * 8;
	// 初期配置
	public static final int FIELD_INIT_EVLEMENT_CENTER_BLACK_ONE = 27;
	public static final int FIELD_INIT_EVLEMENT_CENTER_BLACK_TWO = 36;
	public static final int FIELD_INIT_EVLEMENT_CENTER_WHITE_ONE = 28;
	public static final int FIELD_INIT_EVLEMENT_CENTER_WHITE_TWO = 35;

	// 無効値
	public static final int INVALID = -1;
}
