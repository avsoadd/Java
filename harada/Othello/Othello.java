import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Othello
{
	private static final int OFFSET_LEFT       = -1;
	private static final int OFFSET_RIGHT      = 1;
	private static final int OFFSET_UP         = -8;
	private static final int OFFSET_DOWN       = 8;
	private static final int OFFSET_LEFT_UP    = -9;
	private static final int OFFSET_RIGHT_UP   = -7;
	private static final int OFFSET_LEFT_DOWN  = 7;
	private static final int OFFSET_RIGHT_DOWN = 9;

	private static final int PLAYER_ONE = 0;
	private static final int PLAYER_TWO = 1;

	private static final int FAST_PLAYER_ONE = 0;
	private static final int FAST_PLAYER_TWO = 1;
	private static final int FAST_PLAYER_MAX = 2;

	private Field mField;
	private int mTurnPlayerIndex;

	// コンストラクタ
	public Othello()
	{
		mField = null;
		mTurnPlayerIndex = Def.INVALID;
	}

	// ゲーム実施
	public void play()
	{
		// 初期化
		init();

		// 最後の登録を行ったプレイヤーを設定しておく
		mTurnPlayerIndex = FAST_PLAYER_MAX - 1;
		Player turnPlayer = null;

		int index = Def.INVALID;
		List<PredictionInfo> predictionInfoList = null;

		boolean isChange = true;
		boolean isPreChange = false;

		// オセロ実行処理
		do
		{
			if(null == mField)
			{
				break;
			}

			// 盤面表示
			Display.showDisplay(mField.getField());

			// ターンプレイヤー取得
			turnPlayer = getTurnPlayer();
			if(null == turnPlayer)
			{
				break;
			}

			// ターンプレイヤーの予測情報リストを取得
			predictionInfoList = getPredictionInfoList(turnPlayer.getKomaType());
			// ターンプレイヤーの入力値を取得
			index = turnPlayer.getInput(predictionInfoList);
			Display.showInput(index, turnPlayer);
			// フィールド変更
			isChange = changeField(index, predictionInfoList);

			// 以下いずれかの場合、ゲーム終了
			// ・変更不可が2度続いた
			// ・盤面に未設定の内容がなくなった
			if(((false == isPreChange) && (false == isChange)) ||
				(0 >= mField.getRemainIndex().size()))
			{
				Def.WINNERTYPE winnerType = getWinnerKomaType(mField.getField());

				if(Def.WINNERTYPE.UNKNOWN != winnerType)
				{
					// 盤面表示
					Display.showDisplay(mField.getField());
					Display.showWinner(mField, winnerType);
					break;
				}
			}
			else
			{
				isPreChange = isChange;
			}

		}while(true);
	}

	// 初期化
	private void init()
	{
		Player playerOne = null;
		Player playerTwo = null;
		Random random = new Random();
		switch(random.nextInt(FAST_PLAYER_MAX * (FAST_PLAYER_MAX-1)))
		{
			case FAST_PLAYER_ONE:
				{
					playerOne = new Player(Def.KOMATYPE.BLACK, "プレイヤー1");
					playerTwo = new Npc(Def.KOMATYPE.WHITE, "プレイヤー2(CPU)");
				}
				break;
			case FAST_PLAYER_TWO:
				{
					playerOne = new Npc(Def.KOMATYPE.WHITE, "プレイヤー2(CPU)");
					playerTwo = new Player(Def.KOMATYPE.BLACK, "プレイヤー1");
				}
				break;
			default:
				{
				}
				break;
		}

		if((null != playerOne) && (null != playerTwo))
		{
			mField = new Field(playerOne, playerTwo);
		}
	}

	// 予測情報リスト取得
	private List<PredictionInfo> getPredictionInfoList(Def.KOMATYPE komaType)
	{
		if(null == mField)
		{
			return null;
		}

		Def.KOMATYPE[] field = mField.getField();
		final List<Integer> remainIndexList = mField.getRemainIndex();

		if(null == field)
		{
			return null;
		}

		List<PredictionInfo> resultInfoList = new ArrayList<>();

		// 予測情報を取得する
		for(int setIndex : remainIndexList)
		{
			resultInfoList.addAll(getChangeInfo(setIndex, komaType, field));
		}

		return resultInfoList;
	}

	// フィールド変更
	private boolean changeField(int setIndex, List<PredictionInfo> resultInfo)
	{
		if((null == resultInfo) || 0 >= resultInfo.size())
		{
			// 変更不可の場合、即終了
			return false;
		}

		Def.KOMATYPE komaType = Def.KOMATYPE.UNKNOWN;
		int startIndex = Def.INVALID;
		int lastIndex = Def.INVALID;
		int offset = Def.INVALID;
		for(PredictionInfo predictionInfo : resultInfo)
		{
			if(setIndex == predictionInfo.getSetIndex())
			{
				komaType = predictionInfo.getChangeKomaType();
				offset   = predictionInfo.getOffset();
				if(0 > offset)
				{
					startIndex = predictionInfo.getLastIndex();
					lastIndex  = predictionInfo.getSetIndex();
					offset     = -offset;
				}
				else
				{
					startIndex = predictionInfo.getSetIndex();
					lastIndex  = predictionInfo.getLastIndex();
				}
				for(int index = startIndex; ((startIndex <= index) && (lastIndex >= index)); index += offset)
				{
					mField.setFieldElement(index, komaType);
				}
			}
		}

		mField.removeRemainIndex(setIndex);

		return true;
	}

	// 反転時の情報取得
	private List<PredictionInfo> getChangeInfo(int setIndex, Def.KOMATYPE komaType, Def.KOMATYPE[] field)
	{
		Map<Def.OFFSETTYPE, Integer> offsetMap = new HashMap<>();
		// 横判定
		offsetMap.put(Def.OFFSETTYPE.LEFT, OFFSET_LEFT);				// 左
		offsetMap.put(Def.OFFSETTYPE.RIGHT, OFFSET_RIGHT);				// 右
		// 縦判定
		offsetMap.put(Def.OFFSETTYPE.UP, OFFSET_UP);					// 上
		offsetMap.put(Def.OFFSETTYPE.DOWN, OFFSET_DOWN);				// 下
		// 斜め判定
		offsetMap.put(Def.OFFSETTYPE.LEFT_UP, OFFSET_LEFT_UP);		// 左上
		offsetMap.put(Def.OFFSETTYPE.RIGHT_UP, OFFSET_RIGHT_UP);		// 右上
		offsetMap.put(Def.OFFSETTYPE.LEFT_DOWN, OFFSET_LEFT_DOWN);	// 左下
		offsetMap.put(Def.OFFSETTYPE.RIGHT_DOWN, OFFSET_RIGHT_DOWN);	// 右下

		List<PredictionInfo> resultList = new ArrayList<>();

		PredictionInfo predictionInfo = null;
		for(Map.Entry<Def.OFFSETTYPE, Integer> offset: offsetMap.entrySet())
		{
			predictionInfo = new PredictionInfo(setIndex, offset.getValue(), offset.getKey(), komaType);
			if(Def.INVALID != getRangeLastIndex(setIndex, field, predictionInfo))
			{
				resultList.add(predictionInfo);
			}
		}

		return resultList;
	}

	// 反転範囲最後のインデックス取得
	private int getRangeLastIndex(int setIndex, Def.KOMATYPE[] field, PredictionInfo predictionInfo)
	{
		int lastIndex = Def.INVALID;

		Def.KOMATYPE komaType = predictionInfo.getChangeKomaType();
		int offset            = predictionInfo.getOffset();

		// 下記いずれかの場合、即終了
		// ・フィールドがない
		// ・フィールド範囲外への設定
		// ・既に配置済み
		if((null == field) ||
			(0 > setIndex) || (field.length <= setIndex) ||
			(Def.KOMATYPE.UNKNOWN != field[setIndex]))
		{
			return lastIndex;
		}

		int index = setIndex + offset;
		if((0 > index) || (field.length <= index))
		{
			return lastIndex;
		}

		// 隣り合わせが設定しようとしている駒種別と同じ場合、即終了
		if((komaType == field[index]) ||
			(Def.KOMATYPE.UNKNOWN == field[index]))
		{
			return lastIndex;
		}
		else
		{
			// 次の確認のため、オフセット分進める
			index += offset;
		}

		int changeNum = 0;
		while((0 <= index) && (field.length > index))
		{
			changeNum++;
			if(komaType == field[index])
			{
				// 囲んで反転可能なため、配置可能として確認終了
				lastIndex = index;
				break;
			}
			else if(Def.KOMATYPE.UNKNOWN == field[index])
			{
				// 未配置の場合は確認終了
				break;
			}
			else
			{
				// 次の確認のため、オフセット分進める
				index += offset;
			}
		}

		predictionInfo.setLastIndex(lastIndex);
		predictionInfo.setChangeNum(changeNum);

		return lastIndex;
	}

	// ターンプレイヤー取得
	private Player getTurnPlayer()
	{
		if(null == mField)
		{
			return null;
		}

		int turnPlayerIndex = mTurnPlayerIndex;
		switch(turnPlayerIndex)
		{
		case PLAYER_ONE:
			{
				turnPlayerIndex = PLAYER_TWO;
			}
			break;
		case PLAYER_TWO:
			{
				turnPlayerIndex = PLAYER_ONE;
			}
			break;
		default:
			{
			}
			break;
		}

		final Player[] playerList = mField.getPlayerList();

		Player turnPlayer = null;
		if((0 <= turnPlayerIndex) && (playerList.length > turnPlayerIndex))
		{
			turnPlayer = playerList[turnPlayerIndex];
			mTurnPlayerIndex = turnPlayerIndex;
		}

		return turnPlayer;
	}

	// 勝者の駒種別取得
	private Def.WINNERTYPE getWinnerKomaType(Def.KOMATYPE[] field)
	{
		Def.WINNERTYPE winnerType = Def.WINNERTYPE.UNKNOWN;

		if(null == field)
		{
			return winnerType;
		}

		int blackCnt = 0;
		int whiteCnt = 0;
		for(Def.KOMATYPE komaType : field)
		{
			if(Def.KOMATYPE.BLACK == komaType)
			{
				blackCnt++;
			}
			else if(Def.KOMATYPE.WHITE == komaType)
			{
				whiteCnt++;
			}
			else
			{
				// どちらでもない（配置不可となった場合のものはカウント対象外）
			}
		}

		if(blackCnt > whiteCnt)
		{
			winnerType = Def.WINNERTYPE.BLACK;
		}
		else if(blackCnt < whiteCnt)
		{
			winnerType = Def.WINNERTYPE.WHITE;
		}
		else
		{
			winnerType = Def.WINNERTYPE.DROW;
		}

		return winnerType;
	}

	public static void main(String[] args)
	{
		Othello othello = new Othello();
		othello.play();
	}

}
