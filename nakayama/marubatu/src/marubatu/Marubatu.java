package marubatu;

import java.util.Random;
import java.util.Scanner;

public class Marubatu
{
	//盤面の初期化
	private FieldInfo[][] field = {
			{FieldInfo.NONE,FieldInfo.NONE,FieldInfo.NONE},
			{FieldInfo.NONE,FieldInfo.NONE,FieldInfo.NONE},
			{FieldInfo.NONE,FieldInfo.NONE,FieldInfo.NONE},
	};

	//手の最大回数
	private final int HAND_MAX = 9;

	public void start()
	{
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		//盤面情報の表示
		printField();

		//盤面が埋まるまで交互に○×を配置
		for(int i = 0; i < HAND_MAX; i++)
		{
			//手を入力する
			int playerRow;
			int playerColumn;
			while(true)
			{
				System.out.println("手を入力してください。");
				System.out.print("縦の値[1-3]：");
				playerRow = scanner.nextInt()-1;
				System.out.print("横の値[1-3]：");
				playerColumn = scanner.nextInt()-1;

				if(field[playerRow][playerColumn] == FieldInfo.NONE)
				{
					field[playerRow][playerColumn] = FieldInfo.MARU;
					break;
				}
				else
				{
					System.out.println("そのマスは開いていません。");
					System.out.println("--------------------");
				}
			}
			
			System.out.println("(" + (playerRow+1) + "," + (playerColumn+1) + ")を選択しました。");

			//盤面情報の表示
			printField();

			//勝敗判定
			if(checkClear(FieldInfo.MARU))
			{
				System.out.println("勝ちました！");
				break;
			}

			//相手の手を決める
			int enemyRow;
			int enemyColumn;
			do
			{
				enemyRow = random.nextInt(3);
				enemyColumn = random.nextInt(3);
			}
			while(field[enemyRow][enemyColumn] != FieldInfo.NONE);
			field[enemyRow][enemyColumn] = FieldInfo.BATU;

			System.out.println("相手は(" + (enemyRow+1) + "," + (enemyColumn+1) + ")を選択しました。");

			//盤面情報の表示
			printField();

			//勝敗判定
			if(checkClear(FieldInfo.BATU))
			{
				System.out.println("負けました…");
				break;
			}
			
			//勝敗が決まらなかった場合
			if(i == HAND_MAX-1)
			{
				System.out.println("引き分けです。");
			}
		}
	}

	//盤面の状況を表示する
	private void printField()
	{
		String[] numList = {"１","２","３"};
		int c = 0;
		System.out.println("--------------------");
		System.out.println("　１２３");
		for(FieldInfo[] fRow : field)
		{
			System.out.print(numList[c]);
			c++;

			for(FieldInfo f : fRow)
			{
				System.out.print(f.toString());
			}
			System.out.println("");
		}
		System.out.println("--------------------");
	}

	//3つ並んでいるか判定する
	private boolean checkClear(FieldInfo f)
	{
		//チェック項目のリスト
		int[][] checkList = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
		//チェック項目数
		final int checkCount = 8;
		//チェック項目の要素数
		final int checkIndex = 3;

		for(int c = 0; c < checkCount; c++)
		{
			for(int index = 0; index < checkIndex; index++)
			{
				int row = checkList[c][index] / 3;
				int column = checkList[c][index] % 3;

				if(field[row][column] != f)
				{
					break;
				}
				if(index == 2)
				{
					return true;
				}
			}
		}

		return false;
	}
}
