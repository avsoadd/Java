
public class Judge {

	public void start(Player player1, Hand hand1, Player player2, Hand hand2) {

		System.out.println("じゃんけんを開始します" + "\n");

		for (int i = 0; i < 3; i++) {
			System.out.print("【" + player1.getName() + "】");
			int p1Hand = hand1.randomHand();
			hand1.printHand(p1Hand);
			System.out.print(" vs ");
			System.out.print("【" + player2.getName() + "】");
			int p2Hand = hand1.randomHand();
			hand2.printHand(p2Hand);

			judgeJanken(player1, p1Hand, player2, p2Hand);
		}

		finalJudge(player1, player2);


	}

	public void judgeJanken(Player player1, int p1Hand, Player player2, int p2Hand) {
		if (p1Hand == Hand.STONE && p2Hand == Hand.SCISSORS
			|| p1Hand == Hand.SCISSORS && p2Hand == Hand.PAPER
			|| p1Hand == Hand.PAPER && p2Hand == Hand.STONE) {
			player1.getResult(true);
			System.out.println("\n" + player1.getName() + "の勝ちです" + " " + player1.getWinCount() + "勝" + "\n");
		} else if (p1Hand == Hand.STONE && p2Hand == Hand.PAPER
			|| p1Hand == Hand.SCISSORS && p2Hand == Hand.STONE
			|| p1Hand == Hand.PAPER && p2Hand == Hand.SCISSORS ) {
			player2.getResult(true);
			System.out.println("\n" + player2.getName() + "の勝ちです" + " " + player2.getWinCount() + "勝" + "\n");
		} else {
			System.out.println("\n" + "あいこです" + "\n");
		}

	}

	public void finalJudge(Player player1, Player player2) {
		Player finalWinner = null;

		if (player1.getWinCount() > player2.getWinCount()) {
			finalWinner = player1;
		} else if (player1.getWinCount() < player2.getWinCount()) {
			finalWinner = player2;
		} else if (player1.getWinCount() == player2.getWinCount()) {
			finalWinner = null;
		}

		System.out.print(player1.getName() + player1.getWinCount() + "勝");
		System.out.print("、");
		System.out.print(player2.getName() + player2.getWinCount() + "勝");

		if (finalWinner == null) {
			System.out.println("で" + "決着はつきませんでした");
		}
		System.out.print("で" + finalWinner.getName() + "の勝利です！");


	}
}