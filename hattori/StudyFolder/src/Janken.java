import java.util.Random;
import java.util.Scanner;

public class Janken {
	public static void main(String[] args) {
		int userWin = 0;
		int cpuWin = 0;

		System.out.println("じゃんけんゲーム");
		System.out.println("1~3の数字を入力してください。");
		System.out.println("1:グー、2:チョキ、3:パー");

		while (userWin < 3 || cpuWin < 3) {
			System.out.print("最初はグー、じゃんけん");

			Scanner scan = new Scanner(System.in);
			Random random = new Random();

			int num = scan.nextInt();
			int cpu = random.nextInt(3) + 1;

			System.out.print("user:");
			switch (num) {
			case 1:
				System.out.println("グー");
				break;
			case 2:
				System.out.println("チョキ");
				break;
			case 3:
				System.out.println("パー");
				break;

			default:
				System.out.println("1~3の数字を入力してください");
				break;
			}

			System.out.print("cpu:");
			switch (cpu) {
			case 1:
				System.out.println("グー");
				break;
			case 2:
				System.out.println("チョキ");
				break;
			case 3:
				System.out.println("パー");
				break;
			default:
				System.out.println("");
				break;
			}

			switch (num) {
			case 1:
				switch (cpu) {
				case 1:
					System.out.println("あいこ！");
					break;
				case 2:
					System.out.println("userの勝ち！");
					userWin++;
					break;
				case 3:
					System.out.println("cpuの勝ち！");
					cpuWin++;
					break;
				}
				break;
			case 2:
				switch (cpu) {
				case 1:
					System.out.println("cpuの勝ち！");
					cpuWin++;
					break;
				case 2:
					System.out.println("あいこ！");
					break;
				case 3:
					System.out.println("userの勝ち！");
					userWin++;
					break;
				}
			case 3:
				switch (cpu) {
				case 1:
					System.out.println("userの勝ち！");
					userWin++;
					break;
				case 2:
					System.out.println("cpuの勝ち！");
					cpuWin++;
					break;
				case 3:
					System.out.println("あいこ！");
					break;
				}
			}
		}
	}
}
