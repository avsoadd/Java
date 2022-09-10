package jan;

import java.util.Scanner;

public class Jankenmain {
	public static int setWinNum;
	public static int userNum;

	public static void main(String[] args) {
		System.out.println("じゃんけんゲーム");

		int missNumA = 0;
		int missNumB = 0;
		int winNum = 0;
		int loseNum = 0;

		Scanner sca = new Scanner(System.in);

		for (int j = 0; j < missNumA + 1; j++) {
			System.out.println("勝利が何回まで遊びますでしょうか?");

			setWinNum = sca.nextInt();

			if (setWinNum > 0) {
				System.out.println("ゲームスタート");

			} else {
				System.out.println("エラー：1〜の整数で入力してください。");
				missNumA++;
			}
		}

		for (int i = 0; i < setWinNum + loseNum ; i++) {
			for (int p = missNumB; p < missNumB + 1; p++) {
				System.out.println("playerの番、数字を入力してください。0:グー,1:チョキ,2:パー");
				userNum = sca.nextInt();

				if (userNum == 0) {
					System.out.println("playerは：グー");
				} else if (userNum == 1) {
					System.out.println("playerは：チョキ");
				} else if (userNum == 2) {
					System.out.println("playerは：パー");
				} else {
					System.out.println("エラー：0〜2までの整数で入力してください。");
					missNumB++;
				}
			}
			Npcparts.npcparts();

			if ((userNum == 0) && (Npcparts.npcNum == 1) || (userNum == 1) && (Npcparts.npcNum == 2) || (userNum == 2) && (Npcparts.npcNum == 0)) {
				System.out.println("playerの勝ちです。");
				winNum++;
			} else if ((userNum == 0) && (Npcparts.npcNum == 2) || (userNum == 1) && (Npcparts.npcNum == 0)
					|| (userNum == 2) && (Npcparts.npcNum == 1)) {
				System.out.println("playerの負けです。");
				loseNum++;
			} else {
				System.out.println("引き分け");
				loseNum++;
			}
			
			if (winNum == setWinNum) {
				System.out.println("おめでとうございます！playerもう"+winNum+"勝、ゲーム終了。");
				break;
			}
			
		}
		sca.close();
	}
}
