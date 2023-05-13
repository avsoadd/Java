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
		int[][] board = new int[3][3];
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 3; x++)
			{
				board[x][y]= 0;
			}
		}

		//盤面の表示
		Board(board);



		boolean finish = false;
		int count = 0;	//ターン数
		int win = 0;	//勝敗判定用　0：未確定・引き分け、1：勝ち、2：負け、3：引き分け

		//終了条件を満たすまで続ける
		while(!finish)
		{
			//ターン数のカウントアップ、引き分け判定
			count++;
			if(count > 4)
			{
				win = 3;
				finish = true;
			}


			//プレイヤーの手の入力
			int[] player = new int[2];
			player = Player(board);
			board[player[0]][player[1]] = 1;

			//勝敗判定：プレイヤー
			if(Judge(board,player) != 0)
			{
				//盤面表示
				Board(board);
				win = 1;
				break;
			}


			//CPUの手の入力（最後のターンだけ省く）
			if(!finish)
			{
				int[] enemy = new int[2];
				enemy = Enemy(board);
				board[enemy[0]][enemy[1]] = 2;

				//勝敗判定：CPU
				if(Judge(board,enemy) != 0)
				{
					//盤面表示
					Board(board);
					win = 2;
					break;
				}
			}


			//盤面表示
			Board(board);
		}

		//勝敗表示
		JudgeText(win);

		//ゲーム終了通知
		System.out.println("||==○×ゲーム終了==||");
	}


	//盤面の表示
	/*
		@param board	盤面配列
	*/
	public static void Board(int[][] board)
	{
		System.out.print("   1  2  3\n");
		System.out.print(" ─────");
		for(int y = 0; y < 3; y++)
		{
			System.out.print("\n" + (y+1) + "|");
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
			System.out.print("\n ─────");
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

	//勝敗判定
	/*
		@param board	盤面配列
		@param turn		直前に入力された手 x,y

		@return win		0=未決定、1=確定
	*/
	public static int Judge(int[][] board, int[] turn)
	{
		//勝敗判定記録用
		int win = 0;

		//プレイヤーとCPUどっちの手か
		int player = board[turn[0]][turn[1]];


		//横方向の探索
		for(int x = 0; x < 3; x++)
		{
			//一致しない場合、探索を終了する
			if(board[x][turn[1]] != player)
			{
				break;
			}

			//全て一致した時、勝敗を確定する
			if(x == 2)
			{
				win = 1;
				return win;
			}
		}

		//縦方向の探索
		for(int y = 0; y < 3; y++)
		{
			 //一致しない場合、探索を終了する
			if(board[turn[0]][y] != player)
			{
				break;
			}

			//全て一致した時、勝敗を確定する
			if(y == 2)
			{
				win = 1;
				return win;
			}
		}

		//斜め方向の探索、右下
		for(int xy = 0; xy < 3; xy++)
		{
			//一致しない場合、探索を終了する
			if(board[xy][xy] != player)
			{
				break;
			}

			//全て一致した時、勝敗を確定する
			if(xy == 2)
			{
				win = 1;
				return win;
			}
		}

		//斜め方向の探索、左下
		int y = 2;
		for(int x = 0; x < 3; x++)
		{
			//一致しない場合、探索を終了する
			if(board[x][y] != player)
			{
				break;
			}

			//全て一致した時、勝敗を確定する
			if(x == 2)
			{
				win = 1;
				return win;
			}
			y--;
		}

		return win;
	}

	//勝敗表示
	/*
	 	@param win	勝敗の結果　0=未決定、1=勝ち、2=負け、3：引き分け
	*/
	public static void JudgeText(int win)
	{
		switch(win)
		{
		case 1:
			System.out.println("貴方の勝ちです！\n\n");
			break;

		case 2:
			System.out.println("貴方の負けです。\n\n");
			break;

		case 3:
			System.out.println("引き分けです。\n\n");
			break;

		default:
			System.out.println("ERROR：判定が正常ではありません。\n\n");
			break;
		}
	}

}