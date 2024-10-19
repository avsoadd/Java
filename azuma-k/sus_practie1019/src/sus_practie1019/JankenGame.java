package sus_practie1019;

import java.util.Random;
import java.util.Scanner;

public class JankenGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
         // じゃんけんの選択肢を配列として定義
        String[] jankenChoices = {"グー", "チョキ", "パー"};
        int playerWins = 0;
        int requiredWins = 3; // 指定回数分勝利するまでゲームを続行

        System.out.println("じゃんけんゲームスタート");

        //ジャンケンゲームループ　　　
        while (playerWins < requiredWins) {
            String playerChoice = "";
            {
                System.out.println("じゃんけんぽん！ (グー, チョキ, パー) から選ぶ:");
                playerChoice = scanner.nextLine();
                if (!playerChoice.equals("グー") && !playerChoice.equals("チョキ") && !playerChoice.equals("パー")) {
                	continue;
                }
            }
         // コンピュータの選択をランダムに生成
            String computerChoice = jankenChoices[random.nextInt(3)];
            System.out.println("コンピュータの選択: " + computerChoice);
            
            // 勝敗の判定
            if (playerChoice.equals(computerChoice)) {
                System.out.println("引き分け");
            } else if ((playerChoice.equals("グー") && computerChoice.equals("チョキ")) ||
                       (playerChoice.equals("チョキ") && computerChoice.equals("パー")) ||
                       (playerChoice.equals("パー") && computerChoice.equals("グー"))) {
                System.out.println("勝ち！");
                playerWins++;   // プレイヤーの勝利回数を増加
            } else {
                System.out.println("負け！");
            }
         // 現在の勝利数を表示
            System.out.println("現在の勝利数: " + playerWins + "/" + requiredWins);
        }

        System.out.println(" " + requiredWins + " 回勝ちました。");
        scanner.close();
    }
}
