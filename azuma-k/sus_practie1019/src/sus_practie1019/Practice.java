package sus_practie1019;

import java.util.Random;
import java.util.Scanner;

public class Practice {

    public class JankenGame {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        String[] choices = {"グー", "チョキ", "パー"};
	        int playerWins = 0;
	        int requiredWins = 3; // 指定回数分勝利するまでゲームを続行
	        System.out.println("じゃんけんゲームへようこそ！");

	        while (playerWins < requiredWins) {
	            String playerChoice = getPlayerChoice(scanner);
	            String computerChoice = choices[random.nextInt(3)];
	            System.out.println("コンピュータの選択: " + computerChoice);
	            String result = determineWinner(playerChoice, computerChoice);
	            System.out.println(result);

	            if (result.equals("あなたの勝ち！")) {
	                playerWins++;
	            }

	            System.out.println("現在の勝利数: " + playerWins + "/" + requiredWins);
	        }

	        System.out.println("おめでとうございます！ " + requiredWins + " 回勝利しました。");
	        scanner.close();
	    }

	    private static String getPlayerChoice(Scanner scanner) {
	        String choice = "";
	        while (!choice.equals("グー") && !choice.equals("チョキ") && !choice.equals("パー")) {
	            System.out.println("じゃんけんぽん！ (グー, チョキ, パー) から選んでください:");
	            choice = scanner.nextLine();
	            if (!choice.equals("グー") && !choice.equals("チョキ") && !choice.equals("パー")) {
	                System.out.println("無効な入力です。 (グー, チョキ, パー) から選んでください。");
	            }
	        }
	        return choice;
	    }

	    private static String determineWinner(String playerChoice, String computerChoice) {
	        if (playerChoice.equals(computerChoice)) {
	            return "引き分け！もう一度！";
	        } else if ((playerChoice.equals("グー") && computerChoice.equals("チョキ")) ||
	                   (playerChoice.equals("チョキ") && computerChoice.equals("パー")) ||
	                   (playerChoice.equals("パー") && computerChoice.equals("グー"))) {
	            return "あなたの勝ち！";
	        } else {
	            return "あなたの負け！";
	        }
	    }
	}

}
