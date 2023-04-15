package marubatsu;

import java.util.Random;
import java.util.Scanner;

public class marubatsu
{
	//メイン
	public static void main(String[] args)
	{
		//ゲームスタート通知
		System.out.println("||==○×ゲーム==||\n\n");


		//盤面配列の作成
		//0=配置なし  1=○  2=×
		int[][] board = {{0,0,0},{0,0,0},{0,0,0}};

		//盤面の表示
		Board(board);


		//終了条件を満たすまで続ける
		boolean finish = false;
		while(!finish)
		{
		//プレイヤーの手の入力
		int[] player = new int[2];
		player = Player(board);
		board[player[0]][player[1]] = 1;

		//CPUの手の入力
		int[] enemy = new int[2];
		enemy = Enemy(board);
		board[enemy[0]][enemy[1]] = 2;

		Board(board);
		finish = true;
		}
		//ゲーム終了通知
		System.out.println("||==○×ゲーム終了==||");
	}


	//盤面の表示
	/*
		@param board	盤面配列
	*/
	public static void Board(int[][] board)
	{
		System.out.print("─────");
		for(int y = 0; y < 3; y++)
		{
			System.out.print("\n|");
			for(int x = 0; x < 3 ; x++)
			{
				switch(board[x][y])
				{
				case 0:
					System.out.print("　");
					break;

				case 1:
					System.out.print("○");
					break;

				case 2:
					System.out.print("×");
					break;

				default:
					//エラー表示
					System.out.print("？");
					break;
				}
				System.out.printf("|");
			}
			System.out.print("\n─────");
		}
		System.out.println("\n\n");
	}

	//プレイヤーの手の入力
	/*
		@param board	盤面配列

		@return player	プレイヤーの手 x,y
	*/
	public static int[] Player(int[][] board)
	{
		Scanner scanner = new Scanner(System.in);
		//プレイヤーの手の値 x,y
		int[] player = {0,0};

		//入力
		while(true)
		{
			//横列、ややこしいので1～3
			while(true)
			{
				System.out.println("横の列を指定してください： 1～3");
				player[0] = scanner.nextInt();
				if(player[0] <= 0 || player[0] > 3)
				{
					System.out.println("ERROR：入力が正しくありません。\n");
				}
				else
				{
					player[0]--;
					break;
				}
			}
			//縦列
			while(true)
			{
				System.out.println("縦の列を指定してください： 1～3");
				player[1] = scanner.nextInt();
				if(player[1] <= 0 || player[1] > 3)
				{
					System.out.println("ERROR：入力が正しくありません。\n");
				}
				else
				{
					player[1]--;
					break;
				}
			}

			//重複していたらやり直し
			if(board[player[0]][player[1]] != 0)
			{
				System.out.println("ERROR：その場所は既に入力されています。\n");
			}
			else break;
			}

		return player;
	}

	//CPUの手の入力
	/*
		@param board	盤面配列

		@return enemy	エネミーの手 x,y
	*/
	public static int[] Enemy(int[][] board)
	{
		Scanner scanner = new Scanner(System.in);
		//CPUの手 x.y
		int[] enemy = {0,0};

		while(true)
		{
			//ランダムで0～2の数字指定 x,y
			Random random = new Random();
			enemy[0] = random.nextInt(3);
			enemy[1] = random.nextInt(3);

			//重複していたらやり直し
			if(board[enemy[0]][enemy[1]] == 0)
			{
				break;
			}
		}

		return enemy;
	}
}