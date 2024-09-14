package janken;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		Random random = new Random();

		String[] hands = { "グー", "チョキ", "パー" };
		System.out.println("じゃんけん");
		System.out.println("0:グー, 1:チョキ, 2:パー");

		while (true) {
			System.out.print("選択してくだい (0, 1, 2): ");
			try {
				int user = scn.nextInt();

				if (user < 0 || user > 2) {
					System.out.println("不正な値です。");
					continue;
				}

				int computer = random.nextInt(3);
				System.out.println("コンピューター:" + hands[computer]);

				if (user == computer) {
					System.out.println("引き分けです");
					continue;
				} else if ((user == 0 && computer == 1) || (user == 1 && computer == 2)
						|| (user == 2 && computer == 0)) {
					System.out.println("あなたの勝ちです");
				} else {
					System.out.println("あなたの負けです");
				}
				break;
			} catch (Exception e) {

			}
		}

	}
}
