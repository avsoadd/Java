package janken;

import java.util.Random;
import java.util.Scanner;

public class JankenMain {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("じゃんけんスタート");
		System.out.println("-----------------------------");
		System.out.println("出す手の番号を選んでください(1.グー、2.チョキ、3.パー)");
		Scanner scanner = new Scanner(System.in);
		//入力処理
		int Player = scanner.nextInt();

		//ランダムで敵の出す手を決める
		Random rand = new Random();
		int num = rand.nextInt(3) + １;
		System.out.println(num);
		if(num==1) {
			System.out.println("敵はグーを出しました!");
		}else if(num==2) {
			System.out.println("敵はチョキを出しました!");
		}else {
			System.out.println("敵はパーを出しました!");
		}

		if (Player == num) {
			System.out.println("あいこです!");
		} else {
			int[][] win = {
					{ 1, 2 }, //Playerグー、敵チョキ
					{ 2, 3 }, //Playerチョキ、敵パー
					{ 3, 1 }//Playerパー、敵グー
			};
			boolean isWin=false;
			for(int [] n:win) {
				if(n[0]==Player&&n[1]==num) {
					isWin =true;
					break;
				}
				
			}
			if(isWin) {
				System.out.println("プレイヤーの勝ち😊");
			}else {
				System.out.println("プレイヤーの負け😭");
			}
		}
	}
}
