import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


class GameJanken
{
	/* 定義値 */
	// じゃんけんの手
	public final int GU    = 0;
	public final int PAR   = 1;
	public final int TYOKI = 2;

	// 勝敗
	public final int PLAYERONEWIN = 0;
	public final int PLAYERTWOWIN = 1;
	public final int DROW         = 2;

	public GameJanken()
	{
	}

	public void play()
	{
		int playerOne = -1;
		int playerTwo = -1;
		int iWinner = -1;

		int[] winCntList = {0, 0};

		// じゃんけん勝利回数取得
		int iWinTimes = getWinTimes();

		do
		{
			// プレイヤーの入力値取得
			playerOne = getInput();
			// CPUの入力値取得
			playerTwo = getCPUInput();
			// 勝者取得
			iWinner = getWinner(playerOne, playerTwo);
			// 勝者表示
			winnerDisplay(iWinner);
			// あいこ以外は終了
			if(DROW != iWinner)
			{
				winCntList[iWinner]++;
				if(iWinTimes == winCntList[iWinner])
				{
					// 最後の表示
					finalDisplay(iWinner);
					break;
				}
			}
		}while(true);
	}

	// じゃんけん勝利回数取得
	private int getWinTimes()
	{
		int iRet = 0;

		Scanner scanner = new Scanner(System.in);
		do
		{
			System.out.print("勝利回数を入力してください：");
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

		return iRet;
	}

	// プレイヤーの入力値取得
	private int getInput()
	{
		int inputValue = -1;

		Scanner scanner = new Scanner(System.in);
		do
		{
			System.out.print("出す手を入力【0(グー),1(パー),2(チョキ)】:");
			try
			{
				inputValue = scanner.nextInt();

				if((inputValue < GU) || (inputValue > TYOKI))
				{
					System.out.println("手にできない入力値ですのでもう一度");
				}
				else
				{
					break;
				}
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

		return inputValue;
	}

	// CPUの入力値取得
	private int getCPUInput()
	{
		// 乱数取得（0 ～ 2まで）
		Random rand = new Random();
		int inputValue = rand.nextInt(3);

		System.out.println("CPUの手：" + inputValue);
		return inputValue;
	}


	// 勝者取得
	private int getWinner(int playerOne, int playerTwo)
	{
		// 初期値引き分けのケース
		int iWinner = DROW;

		// プレイヤー勝者のケース
		int[][] specialJugdeList =
		{
			{GU,    TYOKI},
			{PAR,      GU},
			{TYOKI,   PAR},
		};
		for(int[] specialJudge : specialJugdeList)
		{
			if( (2         == specialJudge.length) &&
				(playerOne == specialJudge[0]    ) &&
				(playerTwo == specialJudge[1]    ) )
			{
				iWinner = PLAYERONEWIN;
				break;
			}
		}

		// CPU勝者のケース
		// ※プレイヤー勝者以外で手が異なっているケース
		if(DROW == iWinner)
		{
			if(playerTwo != playerOne)
			{
				iWinner = PLAYERTWOWIN;
			}
		}

		return iWinner;
	}

	// 勝者表示
	private void winnerDisplay(int iWinner)
	{
		if((PLAYERONEWIN <= iWinner) && (DROW >= iWinner))
		{
			String[] judgeStrList =
			{
				"プレイヤーの勝ち",
				"CPUの勝ち",
				"あいこ",
			};
			System.out.println("今回のじゃんけんは" + judgeStrList[iWinner]);
		}
		else
		{
			System.out.println("判定表示時にエラー値");
		}
	}

	// 最後の表示
	private void finalDisplay(int iWinner)
	{
		if((PLAYERONEWIN <= iWinner) && (DROW >= iWinner))
		{
			String[] judgeStrList =
			{
				"プレイヤー",
				"CPU",
				"",
			};
			System.out.println(judgeStrList[iWinner] + "が指定回数分勝利しましたので、終了します");
		}
		else
		{
			System.out.println("判定表示時にエラー値");
		}
	}

	// 起動処理（じゃんけん実行）
	public static void main(String[] args)
	{
		GameJanken janken = new GameJanken();
		janken.play();
	}
}