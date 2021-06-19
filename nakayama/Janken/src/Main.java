import java.util.Random;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Random rnd = new Random();
		
		//手のリスト
		String[] handList = {"グー","チョキ","パー"};
		
		//現在の勝負数
		int nowCount = 1;
		
		System.out.println("何回勝負しますか？");
		System.out.print("勝負回数：");
		
		//勝負回数を入力
		int maxCount = scanner.nextInt();
		
		//入力された回数試合を行う
		while(nowCount <= maxCount)
		{
			//現在の試合数を表示
			System.out.println("----------------------------");
			System.out.println(nowCount + "戦目！");
			
			System.out.println("手を入力してください。");
			System.out.print("1.グー, 2.チョキ, 3.パー：");
			
			//プレイヤーの手を入力
			int playerHand = scanner.nextInt() - 1;
			
			//入力の値が範囲外なら入力しなおし
			while(playerHand < 0 || playerHand > 2)
			{
				System.out.println("----------------------------");
				System.out.println("値が不適切です。");
				System.out.println("手を入力してください。");
				System.out.print("1.グー, 2.チョキ, 3.パー：");
				playerHand = scanner.nextInt() - 1;
			}
			
			//相手の手を決める
			int enemyHand = rnd.nextInt(3);
			
			//お互いの手を表示
			System.out.println("----------------------------");
			System.out.println("自分の手：" + handList[playerHand]);
			System.out.println("相手の手：" + handList[enemyHand]);
			
			//勝敗判定
			if((playerHand == 0 && enemyHand == 1) || (playerHand == 1 && enemyHand == 2) || (playerHand == 2 && enemyHand == 0))
			{
				//勝利
				System.out.println("勝ちました！");
				nowCount++;
			}
			else if(playerHand == enemyHand)
			{
				//あいこ
				System.out.println("あいこでした。");
			}
			else
			{
				//負け
				System.out.println("負けました…");
				nowCount++;
			}
		}
	}

}
