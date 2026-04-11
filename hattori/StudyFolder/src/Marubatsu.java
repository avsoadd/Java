import java.util.Random;
import java.util.Scanner;

public class Marubatsu {
	public static void main(String[] args) throws Exception {
		
		// ボードの初期値を設定
		String[] board = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		// Scannerクラスでコンソールからの入力を受け付ける
		Scanner scan = new Scanner(System.in);
		// Randomクラスのインスタンスを生成する
		Random random = new Random();

		while (true) {

			// ボード表示
			printBoard(board);

			// Scannerで受け取ったプレイヤーの入力をint型の変数に移し替える
			System.out.print("1~9で入力してください: ");
			int num = -1;
			try {
				num = scan.nextInt() - 1;
			} catch(Exception e) {
				num = -1;
				scan.next();
			}
			

			// 入力チェック(不正な値や、既にOやXの入っているマスではないか判定)
			if (num < 0 || num > 8 || board[num].equals("O") || board[num].equals("X")) {
				System.out.println("不正な入力です。");
				continue;
			}

			// 正しい値の場合、入力された番号のマスへOを置く
			board[num] = "O";

			// checkメソッドを呼び出し、勝ち負けが決まっていないか確認
			if (check(board, "O")) {
				// if文がtrueを返した場合、プレイヤーの勝利が確定するため、最終結果のボードを出力し、勝ちと表示
				printBoard(board);
				System.out.println("プレイヤーの勝ち！");
				break;
			}

			int cpu;
			// OもXも入っていないマスにあたるまでランダムに値を生成し続け、空いているマスに当たった時点でループを抜ける
			while (true) {
				cpu = random.nextInt(9);
				if (!board[cpu].equals("O") && !board[cpu].equals("X")) {
					break;
				}
			}

			// while文で確定したマスをXで埋める
			board[cpu] = "X";

			// checkメソッドを呼び出し、勝ち負けが決まっていないか確認
			if (check(board, "X")) {
				// if文がtrueを返した場合、CPUの勝利が確定するため、最終結果のボードを出力し、勝ちと表示
				printBoard(board);
				System.out.println("CPUの勝ち！");
				break;
			}

			// 引き分けチェック
			boolean draw = true;
			for (int i = 0; i < 9; i++) {
				// i番目のboardのマスがOでもXでもなければ
				if (!board[i].equals("O") && !board[i].equals("X")) {
					// boolean型の変数にfalseを渡してループを抜ける
					draw = false;
					break;
				}
			}

			// もし、boolean型の変数drawがtrueを返した場合は、引き分けということがわかるため
			if (draw) {
				// 最終的なボードの内容を出力し、
				printBoard(board);
				// 引き分けと表示
				System.out.println("引き分け！");
				break;
			}
		}
	}

	// 勝敗判定メソッド
	public static boolean check(String[] board, String mark) {
		return (board[0].equals(mark) && board[1].equals(mark) && board[2].equals(mark)) ||
				(board[3].equals(mark) && board[4].equals(mark) && board[5].equals(mark)) ||
				(board[6].equals(mark) && board[7].equals(mark) && board[8].equals(mark)) ||
				(board[0].equals(mark) && board[3].equals(mark) && board[6].equals(mark)) ||
				(board[1].equals(mark) && board[4].equals(mark) && board[7].equals(mark)) ||
				(board[2].equals(mark) && board[5].equals(mark) && board[8].equals(mark)) ||
				(board[0].equals(mark) && board[4].equals(mark) && board[8].equals(mark)) ||
				(board[2].equals(mark) && board[4].equals(mark) && board[6].equals(mark));
	}

	// ボードの出力
	public static void printBoard(String[] b) {
		System.out.println(b[0] + "|" + b[1] + "|" + b[2]);
		System.out.println("-+-+-");
		System.out.println(b[3] + "|" + b[4] + "|" + b[5]);
		System.out.println("-+-+-");
		System.out.println(b[6] + "|" + b[7] + "|" + b[8]);
	}
}