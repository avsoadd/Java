import java.util.Random;
import java.util.Scanner;

public class JankenMain {
	public static void main(String[] args) {
		// Scannerのインスタンスを作成
        Scanner scanner = new Scanner(System.in);
        // Randomのインスタンスを作成
        Random r = new Random();
        
		String[] hand = {"グー", "チョキ", "パー"};
		int score = 0;

        // 勝負回数の入力
        System.out.print("終了条件となる勝利回数を入力してください: ");
        int winning_score = scanner.nextInt();
        System.out.println("あなたが" + winning_score+  "回勝つまでじゃんけんを行います");
        
        // 規定回数勝つまでループ
        for(int count = 1; score < winning_score; count++) {
        	System.out.println("第" + (count) + "回");
        	// プレイヤーの手を入力
        	System.out.println("あなたのじゃんけんの手を入力してください0(グー)、1(チョキ)、2(パー)：");
        	int player_hand = scanner.nextInt();
        	System.out.println("あなたの手:" + hand[player_hand]);
        	
        	// CPUの手を指定（乱数）
        	int cpu_hand = r.nextInt(3);
        	System.out.println("CPUの手:" + hand[cpu_hand]);
        	
        	// 勝敗判定
        	int judge_num = (player_hand - cpu_hand + 3) % 3; 
        	if(judge_num == 2) {
        		System.out.println("結果:あなたの勝ち！");
        		score++;
        	} else if(judge_num == 1) {
        		System.out.println("結果:あなたの負け！");
        	} else {
        		System.out.println("結果:あいこ！");
        	}
        }
        System.out.println("終了です。");

        // 使い終わったらクローズする
        scanner.close();
	}
}