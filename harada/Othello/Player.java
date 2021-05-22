import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// プレイヤークラス
public class Player
{
	// 駒種別
	private Def.KOMATYPE mKomaType;
	// プレイヤー名
	private String mName;

	// コンストラクタ
	public Player(Def.KOMATYPE komaType, String name)
	{
		mKomaType = komaType;
		mName = name;
	}

	// 駒種別取得
	public Def.KOMATYPE getKomaType()
	{
		return mKomaType;
	}

	// プレイヤー名取得
	public String getName()
	{
		return mName;
	}

	// 入力値取得
	public int getInput(List<PredictionInfo> predictionInfoList)
	{
		int iRet = Def.INVALID;
		boolean isSetPossible = false;
		// プレイヤーの手を取得
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		do
		{
			System.out.print("どこに手を配置するか入力してください：");
			try
			{
				iRet = scanner.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("入力値が許可していないものですのでもう一度");
				continue;
			}
			finally
			{
				// 何もしない
			}

			isSetPossible = false;
			for(PredictionInfo predictionInfo : predictionInfoList)
			{
				if(iRet == predictionInfo.getSetIndex())
				{
					isSetPossible = true;
					break;
				}
			}

			if(true == isSetPossible)
			{
				break;
			}
			else
			{
				System.out.println("入力値が設定不可能な位置ですのでもう一度");
			}
		}while(true);

		return iRet;
	}
}
