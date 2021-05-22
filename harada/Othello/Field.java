
import java.util.ArrayList;
import java.util.List;

// フィールドクラス
public class Field
{
	// プレイヤーリスト
	private Player[] mPlayerList;
	// 盤面
	private Def.KOMATYPE[] mField;
	// 盤面の残り配置可能リスト
	private List<Integer> mRemainIndexList;

	public Field(Player playerOne, Player playerTwo)
	{
		mPlayerList = new Player[Def.PLAYERNUM];
		mPlayerList[Def.PLAYERONE] = playerOne;
		mPlayerList[Def.PLAYERTWO] = playerTwo;
		init();
	}

	// 初期化
	private void init()
	{
		mField = new Def.KOMATYPE[Def.FIELDNUM];
		mRemainIndexList = new ArrayList<>(mField.length);
		for(int index = 0; index < mField.length; index++)
		{
			mField[index] = Def.KOMATYPE.UNKNOWN;
			mRemainIndexList.add(index);
		}

		// 初期配置を設定
		mField[Def.FIELD_INIT_EVLEMENT_CENTER_BLACK_ONE] = Def.KOMATYPE.BLACK;
		mField[Def.FIELD_INIT_EVLEMENT_CENTER_BLACK_TWO] = Def.KOMATYPE.BLACK;
		mField[Def.FIELD_INIT_EVLEMENT_CENTER_WHITE_ONE] = Def.KOMATYPE.WHITE;
		mField[Def.FIELD_INIT_EVLEMENT_CENTER_WHITE_TWO] = Def.KOMATYPE.WHITE;

		removeRemainIndex(Def.FIELD_INIT_EVLEMENT_CENTER_BLACK_ONE);
		removeRemainIndex(Def.FIELD_INIT_EVLEMENT_CENTER_BLACK_TWO);
		removeRemainIndex(Def.FIELD_INIT_EVLEMENT_CENTER_WHITE_ONE);
		removeRemainIndex(Def.FIELD_INIT_EVLEMENT_CENTER_WHITE_TWO);
	}

	// プレイヤーリスト取得
	public final Player[] getPlayerList()
	{
		return mPlayerList;
	}

	// 盤面取得
	public final Def.KOMATYPE[] getField()
	{
		return mField;
	}

	// 盤面要素設定
	public boolean setFieldElement(int index, Def.KOMATYPE setKomaType)
	{
		if((0 > index) || (mField.length <= index))
		{
			return false;
		}

		mField[index] = setKomaType;

		return true;
	}

	// 配置可能インデックス取得
	public final List<Integer> getRemainIndex()
	{
		return mRemainIndexList;
	}

	// 盤面の残り配置可能要素削除
	public void removeRemainIndex(int index)
	{
		int removeIndex = 0;

		int size = mRemainIndexList.size();
		for(; removeIndex < size; removeIndex++)
		{
			if(index == mRemainIndexList.get(removeIndex))
			{
				break;
			}
		}

		mRemainIndexList.remove(removeIndex);
	}
}
