/**
 *
 */
package Rock_paper_scissors;

/**
 * @author sallu
 *
 */
import java.util.Scanner;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//試行回数の設定
		int trials = getTrials();
		//ユーザ側のじゃんけん
		int user_hand = getUser_hand();
		//CPU側のじゃんけん（乱数）
		int cpu_hand = getCpu_hand();
	}

	//試行回数を決める
	public static int getTrials() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				System.out.print("勝負する回数を決めてください > ");
				int setTrials = scanner.nextInt();
				if(setTrials <=0 || setTrials >= 1001) {
					System.out.println("【エラー】1000回以内にしたほうがいいです");
				}else {
					return setTrials;
				}
				break;
			}catch (NumberFormatException e) {
				System.out.println("【エラー】半角数字で入力してください");
				scanner.next();

			}
		}
	}

	public static int getUser_hand() {

	}

	public static int getCpu_hand();{

	}
}
