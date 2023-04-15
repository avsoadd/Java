package janken;


//インポート
import java.util.Random;
import java.util.Scanner;


public class janken
{
	//メイン
	public static void main(String[] args)
	{
		//ゲームスタート通知
		System.out.println("||==じゃんけんゲーム==||\n\n");


		//勝負の指定回数を入力
		int game = GameNumber();
		//System.out.println(game);


		//指定回数勝利するまで繰り返し処理
		int win = 0;
		while(game > win)
		{
			System.out.println("勝利回数：" + win + "　　指定回数：" + game);

			//自分の手の指定
			int Player = PlayerHands();
			//CPUの手の決定
			int Enemy = EnemyHands();
			//勝敗の判定
			win += Judge(Player, Enemy);
		}


		//ゲーム終了通知
		System.out.println("勝利回数：" + win + "　　指定回数：" + game);
		System.out.println("||==じゃんけんゲーム終了==||");
	}


	//勝負回数の入力
	/*
		@return Game	プレイヤーが指定した勝負回数
	*/
	public static int GameNumber()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.println("勝利回数を入力してください：");
		int Game = scanner.nextInt();

		return Game;
	}


	//自分の手の指定
	/*
	 	@return PlayerHands	プレイヤーの出した手
	*/
	public static int PlayerHands()
	{
		Scanner scanner = new Scanner(System.in);
		int PlayerHands = 0;

		// 手が正しくない場合は、正しい入力がされるまで繰り返す
		boolean error = true;
		while(error)
		{
			System.out.println("自分の手を入力してください： 0=グー、1=チョキ、2=パー");
			PlayerHands = scanner.nextInt();
			//自分の手を表示
			System.out.print("自分の手：");
			switch(PlayerHands)
			{
			case 0:
				System.out.println("グー");
				error = false;
				break;

			case 1:
				System.out.println("チョキ");
				error = false;
				break;

			case 2:
				System.out.println("パー");
				error = false;
				break;

			default:
				System.out.println("ERROR：指定された手が正しくありません\n\n");
				break;
			}
		}

		return PlayerHands;
	}


	//相手の手の指定
	/*
		@return EnemyHands	CPUの出した手
	*/
	public static int EnemyHands()
	{
		//ランダムで0～2の数字指定
		Random random = new Random();
		int EnemyHands = random.nextInt(3);
		//System.out.println(EnemyHands);

		//CPUの手の表示
		System.out.print("CPUの手：");
		switch(EnemyHands)
		{
		case 0:
			System.out.println("グー\n");
			break;

		case 1:
			System.out.println("チョキ\n");
			break;

		case 2:
			System.out.println("パー\n");
			break;
		}

		return EnemyHands;
	}


	//勝敗の判定
	/*
		@param PlayerHands	プレイヤーの出した手
		@param EnemyHands	CPUの出した手

		@return win			0=負け、1=勝ち
	*/
	public static int Judge(int PlayerHands, int EnemyHands)
	{
		int win = 0;

		//じゃんけん勝敗判定のアルゴリズムを使用
		//(自分の手 - 相手の手 + 3) % 3
		int judge = (PlayerHands - EnemyHands + 3) % 3;

		//判定
		switch(judge)
		{
		//あいこの場合
		case 0:
			System.out.println("あいこです。\n\n");
			break;

		//負けの場合
		case 1:
			System.out.println("貴方の負けです。\n\n");
			break;

		//勝ちの場合
		case 2:
			System.out.println("貴方の勝ちです！\n\n");
			win = 1;
			break;

		default:
			System.out.println("ERROR：判定が正常ではありません。\n\n");
			break;
		}

		return win;
	}

}