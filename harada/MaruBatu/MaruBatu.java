import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MaruBatu
{
	/* 定義値 */
	// プレイヤー識別子（TWOはCPUを含む）
	private final int INVALID     = -1;
	private final int PLAYERONE   = 0;
	private final int PLAYERTWO   = 1;

	// 盤面
	private int[] mField;

	// CPU残り手
	private List<Integer> mCpuIndexList;

	// メソッドコールインターフェース
	private interface CallMethod
	{
		public boolean invoke(int index);
	}

	public MaruBatu()
	{
		mField = new int[9];
		mCpuIndexList = new ArrayList<>(mField.length);
	}

	// ゲーム実行
	public void play()
	{
		// 手番先行プレイヤー取得
		int turnPlayer = getFastPlayer();
		int winner = INVALID;

		// 盤面を初期化
		init();

		int index = INVALID;
		// 盤面表示
		showDisplay();

		do
		{
			// 手を取得
			index = getInput(turnPlayer);

			// ターンプレイヤーの手を設定する
			if(false == setFiledValue(turnPlayer, index))
			{
				System.out.println("入力された手は既に配置済みの為、手を変更してください");
				continue;
			}

			// 盤面表示
			showDisplay();

			// 勝者取得
			winner = getWinner();

			if((INVALID != winner) || (0 == mCpuIndexList.size()))
			{
				// 勝者表示
				showWinner(winner);
				break;
			}
			else
			{
				// 手番変更
				 if(PLAYERONE == turnPlayer)
				 {
					 turnPlayer = PLAYERTWO;
				 }
				 else
				 {
					 turnPlayer = PLAYERONE;
				 }
			}

		}while(true);
	}

	// 初期化処理
	private void init()
	{
		mCpuIndexList.clear();

		for(int index = 0; index < mField.length; index++)
		{
			mField[index] = INVALID;
			mCpuIndexList.add(index);
		}
	}

	// 入力値取得
	private int getInput(int player)
	{
		int iRet = 0;

		if(PLAYERONE == player)
		{
			// プレイヤーの手を取得
			Scanner scanner = new Scanner(System.in);
			do
			{
				System.out.print("どこに手を配置するか入力してください：");
				try
				{
					iRet = scanner.nextInt();
					break;
				}
				catch(InputMismatchException e)
				{
					System.out.println("入力値が許可していないものですのでもう一度");
				}
				finally
				{
					// 何もしない
				}
			}while(true);
		}
		else
		{
			// CPUの手を取得
			iRet = getCpuInputIndex();
		}

		return iRet;
	}

	// CPUの手を取得
	private int getCpuInputIndex()
	{
		int iRet = INVALID;

		// まとめて確認すると確認する手次第（先に確認するもので決まる）で、
		// 勝つ手または負けない手が別れるため、
		// 勝つ手の後、負けない手を必ず確認するよう対応

		CallMethod isCpuWinner = new CallMethod()
		{
			public boolean invoke(int index)
			{
				return isJudge(index, PLAYERONE);
			}
		};

		CallMethod isCpuDefeat = new CallMethod()
		{
			public boolean invoke(int index)
			{
				return isJudge(index, PLAYERTWO);
			}
		};

		CallMethod isFieldCenter = new CallMethod()
		{
			public boolean invoke(int index)
			{
				return (4 == index);
			}
		};

		// 確認する順番は下記の通り
		// ・盤面で勝てそうな場合、勝つ手を取得
		// ・盤面で負けそうな場合、負けないよう手を取得
		// ・盤面真ん中があれば、真ん中を手とする
		List<CallMethod> callMethodList = new ArrayList<>();
		callMethodList.add(isCpuWinner);
		callMethodList.add(isCpuDefeat);
		callMethodList.add(isFieldCenter);
		for(CallMethod callmethod : callMethodList)
		{
			for(int index : mCpuIndexList)
			{
				if(true == callmethod.invoke(index))
				{
					iRet = index;
					break;
				}
			}
		}

		// ループ内で手を取得できない場合、乱数で手を取得
		if(INVALID == iRet)
		{
			// 乱数取得（残りの盤面手配まで）
			Random rand = new Random();
			int inputValue = rand.nextInt(mCpuIndexList.size());
			iRet = mCpuIndexList.get(inputValue);
		}

		return iRet;
	}

	// 指定された手でゲーム終了かどうか判断
	private boolean isJudge(int index, int player)
	{
		boolean isRet = false;

		// 横判定リスト
		int[][] judgeLineList = {
				{0, 1, 2},
				{3, 4, 5},
				{6, 7, 8},
		};

		// 縦判定リスト
		int[][] judgeColumnList = {
				{0, 3, 6},
				{1, 4, 7},
				{2, 5, 8},
		};

		// 斜め判定リスト
		int[][] judgeDiagonalList = {
				{0, 4, 8},
				{2, 4, 6},
		};

		// 各判定リストを格納するリストを設定
		List<int[][]> judgeLists = new ArrayList<>();
		judgeLists.add(judgeLineList);
		judgeLists.add(judgeColumnList);
		judgeLists.add(judgeDiagonalList);

		// 配列をコピー（コピー元が更新されないよう対応）
		int[] field = Arrays.copyOf(mField, mField.length);

		// 指定された手を仮として設定
		field[index] = player;

		// 各判定リストのいずれかの内容でゲーム終了か判断
		for(int[][] judgeList : judgeLists)
		{
			for(int judgeIndex = 0; judgeIndex < judgeList.length; judgeIndex++)
			{
				if(player == getJudge(judgeList[judgeIndex], field))
				{
					isRet = true;
					break;
				}
			}
			if(true == isRet)
			{
				break;
			}
		}

		return isRet;
	}

	// フィールドに手を設定する
	private boolean setFiledValue(int player, int index)
	{
		boolean isSet = false;
		if(index > mField.length)
		{
			System.out.println("設定不可な入力値のため、もう一度");

			return isSet;
		}

		if(INVALID == mField[index])
		{
			// 手が未設定の盤面に入力値を設定
			mField[index] = player;
			isSet = true;

			// 設定した場所はCPUの手から削除する
			int size = mCpuIndexList.size();
			int removeIndex = 0;
			for(; removeIndex < size; removeIndex++)
			{
				if(index == mCpuIndexList.get(removeIndex))
				{
					break;
				}
			}
			mCpuIndexList.remove(removeIndex);
		}

		return isSet;
	}

	// 手番先行プレイヤー取得
	private int getFastPlayer()
	{
		// 乱数取得（0 ～ 1まで）
		Random rand = new Random();
		int inputValue = rand.nextInt(2);

		if(PLAYERONE == inputValue)
		{
			System.out.println("先手はプレイヤー1");
		}
		else
		{
			System.out.println("先手はプレイヤー2(CPU)");
		}

		return inputValue;

	}

	// 勝者取得
	private int getWinner()
	{
		// 横判定リスト
		int[][] judgeLineList = {
				{0, 1, 2},
				{3, 4, 5},
				{6, 7, 8},
		};

		// 縦判定リスト
		int[][] judgeColumnList = {
				{0, 3, 6},
				{1, 4, 7},
				{2, 5, 8},
		};

		// 斜め判定リスト
		int[][] judgeDiagonalList = {
				{0, 4, 8},
				{2, 4, 6},
		};

		// 各判定リストを格納するリストを設定
		List<int[][]> judgeLists = new ArrayList<>();
		judgeLists.add(judgeLineList);
		judgeLists.add(judgeColumnList);
		judgeLists.add(judgeDiagonalList);

		int iWinner = INVALID;
		// 各判定リストのいずれかの内容でゲーム終了か判断
		for(int[][] judgeList : judgeLists)
		{
			for(int index = 0; index < judgeList.length; index++)
			{
				iWinner = getJudge(judgeList[index], mField);
				if(INVALID != iWinner)
				{
					break;
				}
			}
			if(INVALID != iWinner)
			{
				break;
			}
		}

		return iWinner;
	}

	// 指定された判定の結果を取得
	private int getJudge(int[] judgeList, int[] field)
	{
		int winner = INVALID;

		if((null == judgeList) || (null == field))
		{
			return winner;
		}

		winner = field[judgeList[0]];

		for(int index = 1; index < judgeList.length; index++)
		{
			if(winner != field[judgeList[index]])
			{
				winner = INVALID;
				break;
			}
		}

		return winner;
	}

	// 盤面表示
	private void showDisplay()
	{
		// 入力値表作成
		String[] strList = {
				"|０|１|２",
				"－－－－－",
				"|３|４|５",
				"－－－－－",
				"|６|７|８",
		};

		// 現在の結果表作成
		List<String> resultStrList = new ArrayList<>(strList.length);

		String str = "";
		for(int index = 0; index < mField.length; index++)
		{
			str += "|";
			if(PLAYERONE == mField[index])
			{
				str += "○";
			}
			else if(PLAYERTWO == mField[index])
			{
				str += "×";
			}
			else
			{
				str += "　";
			}

			if((index+1) % 3 == 0)
			{
				str += "|";
				resultStrList.add(str);
				str = "";
				if((index+1) != mField.length)
				{
					str += "－－－－－";
					resultStrList.add(str);
					str = "";
				}
			}
		}

		// 入力値表と現在の結果表をコマンドプロンプトに表示する
		System.out.println("--------------------");
		System.out.println("入力値表 |  結果表  ");
		System.out.println("--------------------");

		for(int index = 0; index < strList.length; index++)
		{
			System.out.println(strList[index] + resultStrList.get(index));
		}

		System.out.println("--------------------");

	}

	// 勝者表示
	private void showWinner(int winner)
	{
		String[] strList = {
				"プレイヤー1",
				"プレイヤー2(CPU)",
		};

		if((0 <= winner) && (winner < strList.length))
		{
			System.out.println(strList[winner] + "の勝ちです");
		}
		else if(INVALID == winner)
		{
			System.out.println("入力対象がないため、ドローです");
		}
		else
		{
		}
	}

	// メインスレッド
	public static void main(String[] args)
	{
		MaruBatu maruBatu = new MaruBatu();
		maruBatu.play();
	}

}
