import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Npcクラス
public class Npc extends Player
{
	// コンストラクタ
	public Npc(Def.KOMATYPE komaType, String name)
	{
		super(komaType, name);
	}

	// 入力値取得
	public int getInput(List<PredictionInfo> predictionInfoList)
	{
		int iRet = Def.INVALID;

		// 配置可能な中で最も反転数が多いものを選択する
		int changeNum = Def.INVALID;
		int changeMaxNum = Def.INVALID;

		List<Integer> indexList = new ArrayList<>();
		for(PredictionInfo predictionInfo : predictionInfoList)
		{
			changeNum = predictionInfo.getChangeNum();
			if(changeMaxNum < changeNum)
			{
				changeMaxNum = changeNum;
				indexList.clear();
				indexList.add(predictionInfo.getSetIndex());
			}
			else if(changeMaxNum == changeNum)
			{
				indexList.add(predictionInfo.getSetIndex());
			}
			else
			{
			}
		}

		int size = indexList.size();
		if(0 < size)
		{
			int index = 0;
			// 変更数が同じものがある場合、乱数で取得した位置を入力値とする
			if(1 < size)
			{
				Random random = new Random();
				index = random.nextInt(size);
			}
			iRet = indexList.get(index);
		}

		return iRet;
	}
}
