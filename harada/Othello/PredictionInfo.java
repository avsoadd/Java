
// 予測情報
public class PredictionInfo {
	// 設定位置（反転範囲最初の位置）
	private int mSetIndex;
	// 反転範囲最後の位置
	private int mLastIndex;
	// オフセット
	private int mOffset;
	// オフセット種別
	private Def.OFFSETTYPE mOffsetType;
	// 反転後の駒種別
	private Def.KOMATYPE mChangeKomaType;
	// 反転する駒の数
	private int mChangeNum;

	// コンストラクタ
	public PredictionInfo(int setIndex, int offset, Def.OFFSETTYPE offsetType, Def.KOMATYPE changeKomaType)
	{
		mSetIndex       = setIndex;
		mLastIndex      = Def.INVALID;
		mOffset         = offset;
		mOffsetType     = offsetType;
		mChangeKomaType = changeKomaType;
		mChangeNum      = Def.INVALID;
	}

	// 反転範囲最後の位置設定
	public void setLastIndex(int lastIndex)
	{
		mLastIndex = lastIndex;
	}

	// 反転する駒の数設定
	public void setChangeNum(int changeNum)
	{
		mChangeNum = changeNum;
	}

	// 設定位置取得
	public int getSetIndex()
	{
		return mSetIndex;
	}

	// 反転範囲最後の位置取得
	public int getLastIndex()
	{
		return mLastIndex;
	}

	// オフセット取得
	public int getOffset()
	{
		return mOffset;
	}

	// オフセット種別取得
	public Def.OFFSETTYPE getOffsetType()
	{
		return mOffsetType;
	}

	// 反転後の駒種別取得
	public Def.KOMATYPE getChangeKomaType()
	{
		return mChangeKomaType;
	}

	// 反転する駒の数取得
	public int getChangeNum()
	{
		return mChangeNum;
	}
}
