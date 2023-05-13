import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void show_hand(int handnum) {
		switch (handnum) {
		case 0:
			System.out.println("グー");
			break;

		case 1:
			System.out.println("チョキ");
			break;

		case 2:
			System.out.println("パー");
			break;

		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		int result = 0;
		// payer 0:default, 1:win, 2:lose, 3:draw

		int wincount = 0;
		int losecount = 0;

		// int playcount = 0;

		System.out.print("何回勝利で終了？");
		int maxwincount = input.nextInt();

		for (;;) {

			System.out.print("あなたが出す手を入力（0:go, 1:tyoki, 2:pa）：");
			int player = input.nextInt();
			int cpu = rand.nextInt(3);
			// 0:go, 1:tyoki, 2:pa

			if (!(player >= 0 && player <= 2)) {
				System.out.println("正しい手の数値を入力（0 ~ 2）\n");
				continue;
			}

			System.out.println("***************");
			System.out.print("あなた:");
			show_hand(player);
			System.out.print("CPU:");
			show_hand(cpu);
			System.out.println("***************");
			System.out.print("結果：");

			if (player == cpu) {
				System.out.println("あいこ　もう一回\n");
				continue;

			} else {
				switch (cpu) {
				case 0: { // CPUがグーの時
					if (player == 1)
						result = 2;
					else
						result = 1;
				}
					break;

				case 1: {
					if (player == 0)
						result = 1;
					else
						result = 2;
				}
					break;

				case 2: {
					if (player == 0)
						result = 2;
					else
						result = 1;
				}
					break;
				}

				if (result == 1) {
					System.out.println("あなたの勝ち");
					wincount++;
				} else {
					System.out.println("あなたの負け");
					losecount++;
				}

				if (wincount >= maxwincount) {
					System.out.println(maxwincount + "勝したので終了");
					break;
				} else {
					System.out.println("残り" + (maxwincount - wincount) + "勝で終了\n");
				}
			} // for文ラスト

		}
	}

}
